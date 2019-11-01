package com.t248.appinfo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "app_info")
public class AppInfo {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 软件名称
     */
    @Column(name = "softwareName")
    private String softwareName;

    /**
     * APK名称（唯一）
     */
    @Column(name = "APKName")
    private String APKName;

    /**
     * 支持ROM
     */
    @Column(name = "supportROM")
    private String supportROM;

    /**
     * 界面语言
     */
    @Column(name = "interfaceLanguage")
    private String interfaceLanguage;

    /**
     * 软件大小（单位：M）
     */
    @Column(name = "softwareSize")
    private BigDecimal softwareSize;

    /**
     * 更新日期
     */
    @Column(name = "updateDate")
    private Date updateDate;

    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    @Column(name = "devId")
    private Long devId;

    /**
     * 应用简介
     */
    @Column(name = "appInfo")
    private String appInfo;

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    @Column(name = "status")
    private Long status;

    /**
     * 上架时间
     */
    @Column(name = "onSaleDate")
    private Date onSaleDate;

    /**
     * 下架时间
     */
    @Column(name = "offSaleDate")
    private Date offSaleDate;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    @Column(name = "flatformId")
    private Long flatformId;

    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    @Column(name = "categoryLevel3")
    private Long categoryLevel3;

    /**
     * 下载量（单位：次）
     */
    @Column(name = "downloads")
    private Long downloads;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    @Column(name = "createdBy")
    private Long createdBy;

    /**
     * 创建时间
     */
    @Column(name = "creationDate")
    private Date creationDate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    @Column(name = "modifyBy")
    private Long modifyBy;

    /**
     * 最新更新时间
     */
    @Column(name = "modifyDate")
    private Date modifyDate;

    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    @Column(name = "categoryLevel1")
    private Long categoryLevel1;

    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    @Column(name = "categoryLevel2")
    private Long categoryLevel2;

    /**
     * LOGO图片url路径
     */
    @Column(name = "logoPicPath")
    private String logoPicPath;

    /**
     * LOGO图片的服务器存储路径
     */
    @Column(name = "logoLocPath")
    private String logoLocPath;

    /**
     * 最新的版本id
     */
    @Column(name = "versionId")
    private Long versionId;



}