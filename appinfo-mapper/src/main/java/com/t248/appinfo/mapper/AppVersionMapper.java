package com.t248.appinfo.mapper;

import com.t248.appinfo.model.AppVersion;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface AppVersionMapper extends MyMapper<AppVersion> {
     int addVersion(AppVersion version);
}