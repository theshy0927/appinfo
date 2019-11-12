package com.t248.appinfo.utils;

import java.lang.reflect.Field;

public class SolrQueryParamConvert {

    public static Object convert(Object object) throws IllegalAccessException {
        Field[] declaredFields =object.getClass().getDeclaredFields();
        for (Field field :declaredFields){
            Object o = field.get(object);
            if (o instanceof String && (o==null || o.equals(""))){
                field.set(o,"*");
            }
        }

        return object;
    }
}
