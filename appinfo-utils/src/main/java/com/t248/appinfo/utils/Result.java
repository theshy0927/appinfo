package com.t248.appinfo.utils;


public class Result {

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private Object data;

    public Object getData() {
        return data;
    }

    public static Result errorOf(AppinfoCode ac){
        return error(ac.getCode(),ac.getMessage());
    }


    public static Result errorOf(AppinfoException ac){
        return error(ac.getCode(),ac.getMessage());
    }

    private static Result error(Integer code,String message){
        Result result = new Result();
        result.code = code;
        result.message = message;
        return result;
    }
    public static Result okOf(Object data){
        Result result = new Result();
        result.data = data;
        result.code=200;
        result.message="请求成功";
        return result;
    }
}
