package com.t248.appinfo.mapper;

import com.t248.appinfo.model.AppCategory;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface AppCategoryMapper extends MyMapper<AppCategory> {
}