package com.t248.appinfo.utils;

public enum AppinfoCode {
    login_error(2001,"登录失败,请检查自己的账号和密码!!!"),
    not_login(2002,"未登录,请登录后再重试"),
    server_error(5000,"服务器错误,请稍后重试"),


    app_not_find(2003,"app不存在或已经下架" );

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    AppinfoCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
