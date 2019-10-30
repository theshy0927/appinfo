package com.t248.appinfo.mapper;

import com.t248.appinfo.model.DevUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface DevUserMapper extends MyMapper<DevUser> {
}