package com.t248.appinfo.utils;

import nl.bitwalker.useragentutils.UserAgent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TokenGenerator {

    //生成token(格式为token:设备-id-时间-六位随机数)
    public static String generateToken(String userAgent, Long  id){
        StringBuilder token = new StringBuilder();
        //加token:
        token.append("token:");
        //加设备
        UserAgent userAgent1 = UserAgent.parseUserAgentString(userAgent);
        if (userAgent1.getOperatingSystem().isMobileDevice()){
            token.append("MOBILE-");
        } else {
            token.append("PC-");
        }
        //加加密的用户名
        token.append(id + "-");
        //加时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "-");
        //加六位随机数111111-999999
        token.append(new Random().nextInt((999999 - 111111 + 1)) + 111111);
        System.out.println("token=>" + token.toString());
        return token.toString();
    }
}
