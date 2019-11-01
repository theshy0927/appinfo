package com.t248.appinfo.service;

import com.github.pagehelper.Page;
import com.t248.appinfo.dto.AppinfoDTO;
import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.mapper.AppInfoMapper;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.utils.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppinfoService {
    @Autowired
    private AppInfoMapper mapper;
    public Page<AppinfoDTO> findAppAll(QueryParam info){

        Page<AppinfoDTO> app = mapper.findApp(info);
        return app;
    }

 public    List<CategoryDTO> getAllCategory(Long parentId, String cateLevel){
        return mapper.getAllCategory(parentId, cateLevel);
    }

    public List<DataDictionary>  getFlaform(String typeCode){
        return mapper.getFlaform(typeCode);
    }
}
