package com.t248.appinfo.web.controller;


import com.alibaba.fastjson.JSON;
import com.t248.appinfo.utils.AppinfoCode;
import com.t248.appinfo.utils.AppinfoException;
import com.t248.appinfo.utils.Result;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView error(Throwable ex, Model model, HttpServletRequest request, HttpServletResponse response) {
        String contentType = request.getContentType();
        if("application/json".equals(contentType)) {
            Result dto =null;
            if(ex instanceof AppinfoException) {
                dto = Result.errorOf((AppinfoException)ex);
            }else {
                dto = Result.errorOf(AppinfoCode.server_error);
            }
            PrintWriter writer = null;
            try {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                writer	= response.getWriter();
                writer.print(JSON.toJSONString(dto));
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                writer.close();
            }
            return null;
        }else {
            if(ex instanceof AppinfoException) {
                model.addAttribute("message", ex.getMessage());
                model.addAttribute("code", ((AppinfoException) ex).getCode());
            }else {
                model.addAttribute("message", "服务器冒烟了，请你稍后再重试");
                model.addAttribute("code", 500);
                ex.printStackTrace();
            }
        }
        return 	new ModelAndView("error");
    }
}
