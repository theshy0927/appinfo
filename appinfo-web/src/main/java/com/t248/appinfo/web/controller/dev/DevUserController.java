package com.t248.appinfo.web.controller.dev;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/dev")
@Controller
public class DevUserController {

    @RequestMapping("/main.html")
    public String main(){
        return "/dev/main";
    }


}
