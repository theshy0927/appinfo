package com.t248.appinfo.web.controller.backend;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.t248.appinfo.annotation.TokenValidate;
import com.t248.appinfo.dto.AppVersionDTO;
import com.t248.appinfo.dto.AppinfoDTO;
import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.model.AppInfo;
import com.t248.appinfo.model.BackendUser;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.service.AppVersionService;
import com.t248.appinfo.service.AppinfoService;
import com.t248.appinfo.service.BackendService;
import com.t248.appinfo.solr.AppinfoSolr;
import com.t248.appinfo.utils.*;
import com.t248.appinfo.vo.AppinfoVO;
import com.t248.appinfo.web.config.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/backend")
@Controller
public class BackendUserController {

    @Autowired
    private RedisUtils utils;
    @Autowired
    private AppVersionService versionService;

    @Autowired
    private SolrClient client;



    private void allCategory(){
        List<CategoryDTO> categorylevel1 = service.getAllCategory(null,1);
        List<CategoryDTO> categorylevel2 = new ArrayList<>();
        List<CategoryDTO> categorylevel3 = new ArrayList<>();

        for (CategoryDTO c1 : categorylevel1){
            c1.setNextLevel("c1");
            List<CategoryDTO> templevel2 = service.getAllCategory(c1.getId(),2);
            c1.setChildCategory(templevel2.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
            for (CategoryDTO c2 : templevel2){
                categorylevel2.add(c2);
                c1.setNextLevel("c2");
                List<CategoryDTO> templevel3 = service.getAllCategory(c2.getId(),3);
                c2.setChildCategory(templevel3.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
                for (CategoryDTO c3 : templevel3){
                    c3.setNextLevel(null);
                    categorylevel3.add(c3);
                }
            }
        }
        utils.set("allc1", categorylevel1);
        utils.set("allc2", categorylevel2);
        utils.set("allc3", categorylevel3);
    }
    private void getAllCategory(){

        List<CategoryDTO> categorylevel1 = service.getAppInfoCategory(null, "categorylevel1");
        List<CategoryDTO> categorylevel2 = new ArrayList<>();
        List<CategoryDTO> categorylevel3 = new ArrayList<>();
        utils.set("c1", categorylevel1);

        for (CategoryDTO c1 : categorylevel1){
            c1.setNextLevel("c1");
            List<CategoryDTO> templevel2 = service.getAppInfoCategory(c1.getId(), "categorylevel2");
            c1.setChildCategory(templevel2.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
            for (CategoryDTO c2 : templevel2){
                categorylevel2.add(c2);
                c1.setNextLevel("c2");
                List<CategoryDTO> templevel3 = service.getAppInfoCategory(c2.getId(), "categorylevel3");
                c2.setChildCategory(templevel3.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
                for (CategoryDTO c3 : templevel3){
                    c3.setNextLevel(null);
                    categorylevel3.add(c3);
                }
            }
        }
        utils.set("c1", categorylevel1);
        utils.set("c2", categorylevel2);
        utils.set("c3", categorylevel3);
    }
    private void allDataDictionary(){
        List<DataDictionary> flaform = service.getFlaform(null);
        utils.set("dataDictionary", flaform);
    }


    @TokenValidate
    @RequestMapping("list.html")
    public String findAllApp(HttpServletRequest request, Model model, QueryParam queryParam, @RequestParam(name = "curNo",required = false,defaultValue = "1") Integer curNo){
        queryParam.setQueryStatus(1L);
        if(!utils.hasKey("c1")){
            allCategory();
            getAllCategory();
        }
        if (!utils.hasKey("dataDictionary")){
            allDataDictionary();
        }

        if(queryParam.getQueryCategoryLevel1()!=null){
            model.addAttribute("clist2",utils.getCategoryLevel(queryParam.getQueryCategoryLevel1(),"c2"));
        }
        if(queryParam.getQueryCategoryLevel2()!=null){
            model.addAttribute("clist3",utils.getCategoryLevel(queryParam.getQueryCategoryLevel2(),"c3"));
        }


        List<CategoryDTO> c1 = (List<CategoryDTO>)utils.get("c1");
        model.addAttribute("clist1",c1);
        List<DataDictionary> allDataDictionary = (List<DataDictionary>) utils.get("dataDictionary");
        model.addAttribute("appStatus",allDataDictionary.stream().filter(s->"APP_STATUS".equals(s.getTypeCode())).collect(Collectors.toList()));
        model.addAttribute("appFlatFrom",allDataDictionary.stream().filter(s->"APP_FLATFORM".equals(s.getTypeCode())).collect(Collectors.toList()));
        PageHelper.startPage(curNo, 2);
        Page<AppinfoDTO> page = service.findAppAll(queryParam);
        PageInfo pageInfo = new PageInfo(page,3);

        model.addAttribute("pageData",page.getResult());
        model.addAttribute("page",pageInfo);
        model.addAttribute("queryParam", queryParam);

        return "/backend/list";
    }



    @Autowired
    private BackendService backendService;

    @Autowired
    private AppinfoService service;


    @TokenValidate
    @RequestMapping("/main.html")
    public String main(){
        return "/backend/main";
    }

    @TokenValidate
    @RequestMapping("/logout.html")
    @ResponseBody
    public Result logout(HttpServletRequest request){

        Cookie tokenCookie = Arrays.stream(request.getCookies()).filter(cookie -> "TOKEN_NAME".equals(cookie.getName())).collect(Collectors.toList()).get(0);
        if (utils.hasKey(tokenCookie.getValue()))
            utils.del(tokenCookie.getValue());
        else
            return Result.errorOf(AppinfoCode.not_login);
        tokenCookie.setMaxAge(0);
        System.out.println("正常登出 ====>"+tokenCookie.getValue());
        return Result.okOf(null);
    }


    @TokenValidate
    @RequestMapping("appcheck/{appid}.html")
    public String appcheck(@PathVariable("appid") Long appid,Model model){

        if (!utils.hasKey("dataDictionary")){
            allDataDictionary();
        }
        QueryParam info = new QueryParam();
        info.setId(appid);

        AppinfoVO one = service.findOne(info);
        model.addAttribute("appinfo", one);
        //model.addAttribute("appVersionList", versionService.findByAPPId(appid,null,(List<DataDictionary>) utils.get("dataDictionary")));
        try {
        AppVersionDTO versionDTO = versionService.findById(one.getId(),(List<DataDictionary>) utils.get("dataDictionary"));
            model.addAttribute("appVersion", versionDTO);
        }catch (AppinfoException e){
            model.addAttribute("appVersion", null);
        }


        return "/backend/appcheck";
    }

    @TokenValidate
    @RequestMapping("check")
    @ResponseBody
    public Result check(Long id,Long status,HttpServletRequest request){
        AppInfo select = service.select(id);
        select.setStatus(status);
        BackendUser backendUser = (BackendUser) request.getAttribute("backendUser");
        select.setModifyBy(backendUser.getId());
        select.setModifyDate(new Date());
        boolean modify = service.modify(select);
        if(!modify){
            return Result.errorOf(AppinfoCode.app_not_find);
        }
        return Result.okOf(null);
    }


    @TokenValidate
    @RequestMapping("solrlist.html")
    public String solrlist( Model model, QueryParam queryParam, @RequestParam(name = "curNo",required = false,defaultValue = "1") Integer curNo) throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.setQuery("softwareName:"+(queryParam.getQuerySoftwareName()==null?"*":queryParam.getQuerySoftwareName()));
        query.setFilterQueries("status:1");
        QueryParamCheck(query, queryParam);
        SolrDocumentList tempResults = client.query(query).getResults();
        int total = (int) tempResults.getNumFound();
        query.setStart((curNo-1)*2);
        query.setRows(2);
        SolrDocumentList results =  client.query(query).getResults();
        if(!results.isEmpty()){
            Pager<AppinfoSolr> pager = new Pager<AppinfoSolr>(total,curNo,2);
            List<AppinfoSolr> appinfoSolrs = JSONArray.parseArray(JSON.toJSONString(results), AppinfoSolr.class);
            pager.setList(appinfoSolrs);
            model.addAttribute("page", pager);
            model.addAttribute("pageData", appinfoSolrs);
            model.addAttribute("queryParam", queryParam);
        }
        return "/backend/solrlist";
    }




    private void QueryParamCheck(SolrQuery query,QueryParam queryParam){
        if(queryParam.getQueryCategoryLevel1()!=null &&!queryParam.getQueryCategoryLevel1().equals("")){
            query.setFilterQueries("cname1:"+queryParam.getQueryCategoryLevel1());
        }
        if(queryParam.getQueryCategoryLevel2()!=null &&!queryParam.getQueryCategoryLevel2().equals("")){
            query.setFilterQueries("cname2:"+queryParam.getQueryCategoryLevel2());
        }
        if(queryParam.getQueryCategoryLevel3()!=null &&!queryParam.getQueryCategoryLevel3().equals("")){
            query.setFilterQueries("cname3:"+queryParam.getQueryCategoryLevel3());
        }
        if(queryParam.getQueryFlatformId()!=null &&queryParam.getQueryFlatformId()!=0L){
            query.setFilterQueries("flatformId:"+queryParam.getQueryFlatformId());
        }

    }
}
