package com.t248.appinfo.web.controller.dev;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.t248.appinfo.dto.AppinfoDTO;
import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.model.DevUser;
import com.t248.appinfo.service.AppinfoService;
import com.t248.appinfo.utils.QueryParam;
import com.t248.appinfo.web.config.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/dev")
@Controller
public class DevUserController {



    @Autowired
    private AppinfoService service;

    @Autowired
    private RedisUtils utils;

     private void allCategory(){
         List<CategoryDTO> categorylevel1 = service.getAllCategory(null, "categorylevel1");
         List<CategoryDTO> categorylevel2 = new ArrayList<>();
         List<CategoryDTO> categorylevel3 = new ArrayList<>();
         utils.set("c1", categorylevel1);

         for (CategoryDTO c1 : categorylevel1){
             c1.setNextLevel("c1");
             List<CategoryDTO> templevel2 = service.getAllCategory(c1.getId(), "categorylevel2");
             c1.setChildCategory(templevel2.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
             for (CategoryDTO c2 : templevel2){
                 categorylevel2.add(c2);
                 c1.setNextLevel("c2");
                 List<CategoryDTO> templevel3 = service.getAllCategory(c2.getId(), "categorylevel3");
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

    @RequestMapping("/main.html")
    public String main(){
        return "/dev/main";
    }


    @RequestMapping("list")
    public String findAllApp(HttpServletRequest request,Model model, QueryParam queryParam, @RequestParam(name = "curNo",required = false,defaultValue = "1") Integer curNo){


         if(!utils.hasKey("c1")){
             allCategory();
         }
         if (!utils.hasKey("dataDictionary")){
             allDataDictionary();
         }
        DevUser devUser = (DevUser) request.getSession().getAttribute("devUser");

            queryParam.setCreatedBy(devUser.getId());
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














        return "/dev/list";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(Long id){
        ModelAndView model = new ModelAndView("/dev/edit");


        return model;
    }




}
