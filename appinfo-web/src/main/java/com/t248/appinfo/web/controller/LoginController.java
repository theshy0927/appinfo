package com.t248.appinfo.web.controller;


import com.t248.appinfo.model.BackendUser;
import com.t248.appinfo.model.DevUser;
import com.t248.appinfo.service.BackendService;
import com.t248.appinfo.service.DevUserService;
import com.t248.appinfo.utils.AppinfoCode;
import com.t248.appinfo.utils.AppinfoException;
import com.t248.appinfo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private DevUserService devUserService;

    @Autowired
    private BackendService backendService;

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
    public String backendLogin(){
        return "backendLogin";
    }


    @RequestMapping("backendLogin")
    @ResponseBody
    public Result backendLogin(HttpServletRequest request, @RequestParam("userCode")String userCode, @RequestParam("userPassword")String userPassword){
        BackendUser user = new BackendUser();
        user.setUserCode(userCode);
        user.setUserPassword(userPassword);
        BackendUser login = backendService.login(user);
        boolean bool = login != null;
        if(bool){
            request.getSession().setAttribute("backendUser", login );
        }else{
            return Result.errorOf(AppinfoCode.login_error);
        }
        return Result.okOf(null);
    }

}
