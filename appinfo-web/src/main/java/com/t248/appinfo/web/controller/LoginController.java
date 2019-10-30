package com.t248.appinfo.web.controller;


import com.t248.appinfo.model.DevUser;
import com.t248.appinfo.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private DevUserService devUserService;

    @ResponseBody
    @RequestMapping("devLogin")
    public Boolean devLogin(@RequestParam("devCode")String devCode,@RequestParam("devPassword")String devPassword){
        DevUser user = new DevUser();
        user.setDevcode(devCode);
        user.setDevpassword(devPassword);
        boolean isOk = devUserService.devLogin(user);
        return isOk;
    }

}
