package com.t248.appinfo.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AppinfoDTO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 软件名称
     */
    private String softwareName;

    /**
     * APK名称（唯一）
     */
    private String APKName;

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    private Long status;
    private String statusName;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    private Long flatformId;

    private String flatFormName;


    private BigDecimal softwareSize;

    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    private Long categoryLevel3;

    /**
     * 下载量（单位：次）
     */
    private Long downloads;


    /**
     * 创建时间
     */
    private Date creationDate;


    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    private Long categoryLevel1;

    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    private Long categoryLevel2;

    private String cname1;
    private String cname2;
    private String cname3;
    /**
     * 最新的版本id
     */
    private Long versionId;
    private String versionName;
}
