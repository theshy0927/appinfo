package com.t248.appinfo.web.controller;


import com.t248.appinfo.model.DevUser;
import com.t248.appinfo.service.DevUserService;
import com.t248.appinfo.utils.AppinfoCode;
import com.t248.appinfo.utils.AppinfoException;
import com.t248.appinfo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private DevUserService devUserService;

    @ResponseBody
    @RequestMapping(value = "devLogin" , method = RequestMethod.GET)
    public Result devLogin(HttpServletRequest request, @RequestParam("devCode")String devCode, @RequestParam("devPassword")String devPassword){
        DevUser user = new DevUser();
        user.setDevcode(devCode);
        user.setDevpassword(devPassword);
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


    @RequestMapping("logout")
    public String loginOut(HttpServletRequest request){
        Object devUser = request.getSession().getAttribute("devUser");
        if (devUser!=null) {
            request.removeAttribute("devUser");
        }else {
            throw new AppinfoException(AppinfoCode.not_login);
        }
        System.out.println(devUser);
            return "/index";
    }

}
