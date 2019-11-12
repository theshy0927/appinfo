package com.t248.appinfo.web.intercepter;

import com.t248.appinfo.annotation.TokenValidate;
import com.t248.appinfo.model.BackendUser;
import com.t248.appinfo.utils.AppinfoCode;
import com.t248.appinfo.utils.AppinfoException;
import com.t248.appinfo.utils.Const;
import com.t248.appinfo.web.config.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BackendIntercepter extends HandlerInterceptorAdapter {

    private final String TOKEN_NAME ="TOKEN_NAME";

    @Autowired
    private RedisUtils utils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.getAnnotation(TokenValidate.class)!=null&&!request.getServletPath().matches(Const.NO_INTERCEPTOR_PATH)){
            //System.out.println("backend进入拦截判断");
            Cookie[] cookies = request.getCookies();
            if(cookies.length!=0){
                Cookie token = Arrays.stream(cookies).filter(cookie -> TOKEN_NAME.equals(cookie.getName())).collect(Collectors.toList()).get(0);
                //System.out.println(utils.hasKey(token.getValue()));
                if(utils.hasKey(token.getValue())) {
                    utils.expire(token.getValue(), 60 * 60 * 2);
                    request.setAttribute("backendUser", (BackendUser)utils.get(token.getValue()));
                    return true;
                }
            }
            throw new AppinfoException(AppinfoCode.not_login);
        }
            return true;
    }
}
