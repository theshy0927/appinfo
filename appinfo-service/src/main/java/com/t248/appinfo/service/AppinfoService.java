package com.t248.appinfo.service;

import com.github.pagehelper.Page;
import com.t248.appinfo.dto.AppinfoDTO;
import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.mapper.AppCategoryMapper;
import com.t248.appinfo.mapper.AppInfoMapper;
import com.t248.appinfo.mapper.AppVersionMapper;
import com.t248.appinfo.model.AppCategory;
import com.t248.appinfo.model.AppInfo;
import com.t248.appinfo.model.AppVersion;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.utils.QueryParam;
import com.t248.appinfo.vo.AppinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppinfoService {
    @Autowired
    private AppCategoryMapper categoryMapper;

    @Autowired
    private AppVersionMapper versionMapper;

    @Autowired
    private AppInfoMapper mapper;
    public Page<AppinfoDTO> findAppAll(QueryParam info){

        Page<AppinfoDTO> app = mapper.findApp(info);
        return app;
    }

 public    List<CategoryDTO> getAppInfoCategory(Long parentId, String cateLevel){
        return mapper.getAppInfoCategory(parentId, cateLevel);
    }

    public List<CategoryDTO> getAllCategory(Long parentId,Integer cateLevel){
        return  mapper.getAllCategory(parentId,cateLevel);
    }





    public List<DataDictionary>  getFlaform(String typeCode){
        return mapper.getFlaform(typeCode);
    }

    @Transactional(readOnly = false)
    public int addApp(AppInfo info) {
        return mapper.insert(info);
    }

    public boolean checkAPKNameExsits(AppInfo info) {
        int count = mapper.selectCount(info);
        return count>0;
    }

    public AppInfo getSelectOneAPP(Long id) {
        AppInfo info = new AppInfo();
        info.setId(id);
        return mapper.selectOne(info);
    }

    public boolean modify(AppInfo app) {
        int result = mapper.updateByPrimaryKey(app);
        return result>0;
    }


    public AppinfoVO findOne(QueryParam info){
      return   mapper.findOne(info);
    }


    @Transactional(readOnly = false)
    public boolean delete(Long appid) {
        int result = mapper.deleteByPrimaryKey(appid);
        AppVersion version = new AppVersion();
        version.setAppId(appid);
        versionMapper.delete(version);
        return result>0;
    }

    public AppInfo select(Long id){
        return mapper.selectByPrimaryKey(id);
    }
}
