package com.t248.appinfo.web.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.t248.appinfo.model.BackendUser;
import com.t248.appinfo.model.DevUser;
import com.t248.appinfo.service.BackendService;
import com.t248.appinfo.service.DevUserService;
import com.t248.appinfo.solr.AppinfoSolr;
import com.t248.appinfo.utils.AppinfoCode;
import com.t248.appinfo.utils.AppinfoException;
import com.t248.appinfo.utils.Result;
import com.t248.appinfo.utils.TokenGenerator;
import com.t248.appinfo.web.config.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LoginController {

    @Autowired
    private DevUserService devUserService;

    @Autowired
    private BackendService backendService;

    @Autowired
    private RedisUtils utils;

    @Autowired
    private SolrClient client;

    @RequestMapping("/useSolrbySoftwareName")
    @ResponseBody
    public List<AppinfoSolr> useSolrbySoftwareName(String queryName) throws IOException, SolrServerException {
        List<AppinfoSolr> list = null;
        SolrQuery query = new SolrQuery();
        query.setQuery("softwareName:"+queryName);
        query.setFilterQueries("id:50");
        QueryResponse queryResponse = client.query(query);
        SolrDocumentList results = queryResponse.getResults();
        if(!results.isEmpty()){
//            Gson gson = new Gson();
//            String listString = gson.toJson(results);
//            list = gson.fromJson(listString, new TypeToken<List<AppinfoSolr>>() {}.getType());
            list = JSONArray.parseArray(JSON.toJSONString(results), AppinfoSolr.class);
        }
        return list;
    }



    @ApiOperation(value = "前台登录",httpMethod = "GET",produces = "application/json",protocols = "http",response = Result.class)
    @ResponseBody
    @RequestMapping(value = "devLogin" , method = RequestMethod.GET)
    public Result devLogin(HttpServletRequest request, @RequestParam("devCode")String devCode, @RequestParam("devPassword")String devPassword){
        DevUser user = new DevUser();
        user.setDevCode(devCode);
        user.setDevPassword(devPassword);
        user = devUserService.devLogin(user);
        boolean bool = user != null;
        if(bool){
            request.getSession().setAttribute("devUser", user );
        }else{
            return Result.errorOf(AppinfoCode.login_error);
        }
        return Result.okOf(null);
    }

    @RequestMapping({"","index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping("devlogin.html")
    public String devlogin(){
        return "login";
    }


    @RequestMapping("logout/{status}")
    public String loginOut(@PathVariable("status") int status, HttpServletRequest request){
        if(status==1){
            Object devUser = request.getSession().getAttribute("devUser");
            if (devUser!=null) {
                request.removeAttribute("devUser");
            }else {
                throw new AppinfoException(AppinfoCode.not_login);
            }
        }else{
            Object backendUser = request.getSession().getAttribute("backendUser");
            if (backendUser!=null) {
                request.removeAttribute("backendUser");
            }else {
                throw new AppinfoException(AppinfoCode.not_login);
            }
        }
            return "/index";
    }
    @RequestMapping("backendLogin.html")
    public String backendLogin(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        if(cookies.length!=0){
            List<Cookie> collect = Arrays.stream(cookies).filter(cookie -> "TOKEN_NAME".equals(cookie.getName())).collect(Collectors.toList());
            if(collect.size()!=0){
                Cookie token = collect.get(0);
                if(utils.hasKey(token.getValue())){
                    if(utils.getExpire(token.getValue())>=3600){
                        model.addAttribute("backendUser",utils.get(token.getValue()));
                        return "/backend/main";
                    }
                }
            }
        }
        return "backendLogin";
    }


    @RequestMapping("backendLogin")
    @ResponseBody
    @ApiOperation(value = "后台登录",httpMethod = "GET",produces = "application/json",protocols = "http",response = Result.class)
    public Result backendLogin(HttpServletResponse response, HttpServletRequest request, @RequestParam("userCode")String userCode, @RequestParam("userPassword")String userPassword){

        Cookie[] cookies = request.getCookies();
        if(cookies.length!=0){
                List<Cookie> collect = Arrays.stream(cookies).filter(cookie -> "TOKEN_NAME".equals(cookie.getName())).collect(Collectors.toList());
                if(collect.size()!=0){
                    Cookie token = collect.get(0);
                    if(utils.hasKey(token.getValue())){
                        if(utils.getExpire(token.getValue())<3600){
                            utils.expire(token.getValue(), 60*2);
                            token.setMaxAge(0);
                        }else{
                            return Result.okOf(null);
                        }
                    }
                }
        }
        BackendUser user = new BackendUser();
        user.setUserCode(userCode);
        user.setUserPassword(userPassword);
        BackendUser login = backendService.login(user);
        boolean bool = login != null;
        if(bool){
            String newtoken = TokenGenerator.generateToken(request.getHeader("user-agent"), login.getId());
            utils.set(newtoken, login, 60*60*2);
            Cookie token_name = new Cookie("TOKEN_NAME", newtoken);
            token_name.setPath("/");
            token_name.setMaxAge(-1);
            response.addCookie(token_name);
            //request.getSession().setAttribute("backendUser", login );
        }else{
            return Result.errorOf(AppinfoCode.login_error);
        }
        return Result.okOf(null);
    }

}
