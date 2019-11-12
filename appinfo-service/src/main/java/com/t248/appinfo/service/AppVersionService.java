package com.t248.appinfo.service;

import com.t248.appinfo.dto.AppVersionDTO;
import com.t248.appinfo.mapper.AppVersionMapper;
import com.t248.appinfo.model.AppInfo;
import com.t248.appinfo.model.AppVersion;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.utils.AppinfoCode;
import com.t248.appinfo.utils.AppinfoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppVersionService {

    @Autowired
    private  AppVersionMapper mapper;


    /**
     * 查询版本号  因为之前设计失误  导致 数据表只能从外部传入
     * @param id
     * @param dataList
     * @return
     */
    public List<AppVersionDTO> findByAPPId(Long id,Long publishId, List<DataDictionary> dataList){
        Map<Long, String> collect = dataList.stream().filter(s -> "PUBLISH_STATUS".equals(s.getTypeCode())).collect(Collectors.toMap(k -> k.getValueId(), v -> v.getValueName()));
        AppVersion version = new AppVersion();
        version.setAppId(id);
        if(publishId!=null && publishId != 0L){
            version.setPublishStatus(publishId);
        }
        List<AppVersion> select = mapper.select(version);
        List<AppVersionDTO> list = null;
        if (select!=null && select.size()!=0) {
            list = new ArrayList<>();
            for (AppVersion v: select) {
                AppVersionDTO v2 = new AppVersionDTO();
                BeanUtils.copyProperties(v,v2);
                v2.setStatusName(collect.get(v.getPublishStatus()));
                list.add(v2);
            }
        }
        return list;
    }

    @Transactional(readOnly = false)
    public int addVersion(AppVersion version) {
        return mapper.addVersion(version);
    }

    public AppVersionDTO findById(Long id, List<DataDictionary> dataList) {
        AppVersion version = mapper.selectByPrimaryKey(id);
        if(version==null){
            throw new AppinfoException(AppinfoCode.app_not_find);
        }
        Map<Long, String> collect = dataList.stream().filter(s -> "PUBLISH_STATUS".equals(s.getTypeCode())).collect(Collectors.toMap(k -> k.getValueId(), v -> v.getValueName()));
        AppVersionDTO versionDTO = new AppVersionDTO();
        BeanUtils.copyProperties(version,versionDTO);
        versionDTO.setStatusName(collect.get(version.getPublishStatus()));
        return versionDTO;
    }


@Transactional(readOnly = false)
    public boolean modify(AppVersionDTO appVersion) {
        AppVersion version = new AppVersion();
        BeanUtils.copyProperties(appVersion, version);

        return  mapper.updateByPrimaryKey(version)>0;
    }
}
