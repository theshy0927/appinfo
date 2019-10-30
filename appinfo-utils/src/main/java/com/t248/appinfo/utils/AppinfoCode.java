package com.t248.appinfo.utils;

public enum AppinfoCode {
    login_error(2001,"登录失败!!!");


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
