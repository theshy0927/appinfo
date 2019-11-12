package com.t248.appinfo.utils;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Result",description ="返回模型")
public class Result {


    @ApiModelProperty(value = "响应码")
    private Integer code;
    @ApiModelProperty("响应信息")
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @ApiModelProperty("响应数据")
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
