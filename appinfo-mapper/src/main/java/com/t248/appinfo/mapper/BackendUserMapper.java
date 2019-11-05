package com.t248.appinfo.mapper;

import com.t248.appinfo.model.BackendUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;
@Repository
public interface BackendUserMapper extends MyMapper<BackendUser> {
}