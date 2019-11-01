package com.t248.appinfo.service;


import com.t248.appinfo.mapper.DevUserMapper;
import com.t248.appinfo.model.DevUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;


    /**
     * 使用密码和code进行登录验证登录验证
     * @param user
     * @return
     */
    public DevUser devLogin(DevUser user){
        return devUserMapper.selectOne(user);
    }



}
