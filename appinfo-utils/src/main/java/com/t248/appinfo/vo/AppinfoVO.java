package com.t248.appinfo.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class AppinfoVO {

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
     * 支持ROM
     */
    private String supportROM;

    /**
     * 界面语言
     */
    private String interfaceLanguage;

    /**
     * 软件大小（单位：M）
     */
    private BigDecimal softwareSize;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    private Long devId;

    /**
     * 应用简介
     */
    private String appInfo;

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    private Long status;

    /**
     * 上架时间
     */
    private Date onSaleDate;

    /**
     * 下架时间
     */
    private Date offSaleDate;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    private Long flatformId;

    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    private Long categoryLevel3;

    /**
     * 下载量（单位：次）
     */
    private Long downloads;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    private Long modifyBy;

    /**
     * 最新更新时间
     */
    private Date modifyDate;

    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    private Long categoryLevel1;

    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    private Long categoryLevel2;

    /**
     * LOGO图片url路径
     */
    private String logoPicPath;

    /**
     * LOGO图片的服务器存储路径
     */
    private String logoLocPath;

    /**
     * 最新的版本id
     */
    private Long versionId;



    private String statusName;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */

    private String flatFormName;



    private String cname1;
    private String cname2;
    private String cname3;
    /**
     * 最新的版本id
     */
    private String versionName;
}
