package com.t248.appinfo.mapper;

import com.github.pagehelper.Page;
import com.t248.appinfo.dto.AppinfoDTO;
import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.model.AppInfo;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.utils.QueryParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

import java.util.List;


@Repository
public interface AppInfoMapper extends MyMapper<AppInfo> {

    Page<AppinfoDTO> findApp(QueryParam appinfo);


    List<CategoryDTO> getAllCategory(@Param("parentId") Long parentId,@Param("cateLevel") String cateLevel);

    List<DataDictionary>  getFlaform(@Param("typeCode") String typeCode);
}