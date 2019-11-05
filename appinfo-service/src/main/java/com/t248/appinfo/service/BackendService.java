package com.t248.appinfo.service;

import com.t248.appinfo.mapper.BackendUserMapper;
import com.t248.appinfo.model.BackendUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackendService {

    @Autowired
    private BackendUserMapper mapper;

    public BackendUser login(BackendUser user) {
        return mapper.selectOne(user);
    }
}
