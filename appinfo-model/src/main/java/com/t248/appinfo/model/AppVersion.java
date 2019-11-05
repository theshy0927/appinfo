package com.t248.appinfo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "app_version")
public class AppVersion {
    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * appId（来源于：app_info表的主键id）
     */
    @Column(name ="appId")
    private Long appId;

    /**
     * 版本号
     */
    @Column(name = "versionNo")
    private String versionNo;

    /**
     * 版本介绍
     */
    @Column(name = "versionInfo")
    private String versionInfo;

    /**
     * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    @Column(name = "publishStatus")
    private Long publishStatus;

    /**
     * 下载链接
     */
    @Column(name = "downloadLink")
    private String downloadLink;

    /**
     * 版本大小（单位：M）
     */
    @Column(name = "versionSize")
    private BigDecimal versionSize;

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
     * apk文件的服务器存储路径
     */
    @Column(name = "apkLocPath")
    private String apkLocPath;

    /**
     * 上传的apk文件名称
     */
    @Column(name = "apkFileName")
    private String apkFileName;

    
    
}