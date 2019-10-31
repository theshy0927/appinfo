package com.t248.appinfo.utils;

public enum AppinfoCode {
    login_error(2001,"登录失败,请检查自己的账号和密码!!!"),
    not_login(2002,"未登录,请登录后再重试")



    ;

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
