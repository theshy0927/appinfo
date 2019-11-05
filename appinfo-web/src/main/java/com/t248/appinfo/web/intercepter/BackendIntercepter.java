package com.t248.appinfo.web.intercepter;

import com.t248.appinfo.utils.AppinfoCode;
import com.t248.appinfo.utils.AppinfoException;
import com.t248.appinfo.utils.Const;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackendIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getServletPath().matches(Const.NO_INTERCEPTOR_PATH)){
            if (request.getSession().getAttribute("backendUser")==null)
                throw new AppinfoException(AppinfoCode.not_login);
        }
        return true;
    }
}
