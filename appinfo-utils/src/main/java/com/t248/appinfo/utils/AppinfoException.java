package com.t248.appinfo.utils;

public class AppinfoException extends RuntimeException {

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public AppinfoException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public AppinfoException(AppinfoCode ac){
        this.code = ac.getCode();
        this.message = ac.getMessage();
    }
}
