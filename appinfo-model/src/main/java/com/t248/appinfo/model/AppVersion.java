package com.t248.appinfo.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "app_version")
public class AppVersion {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * appId（来源于：app_info表的主键id）
     */
    @Column(name = "appId")
    private Long appid;

    /**
     * 版本号
     */
    @Column(name = "versionNo")
    private String versionno;

    /**
     * 版本介绍
     */
    @Column(name = "versionInfo")
    private String versioninfo;

    /**
     * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    @Column(name = "publishStatus")
    private Long publishstatus;

    /**
     * 下载链接
     */
    @Column(name = "downloadLink")
    private String downloadlink;

    /**
     * 版本大小（单位：M）
     */
    @Column(name = "versionSize")
    private BigDecimal versionsize;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    @Column(name = "createdBy")
    private Long createdby;

    /**
     * 创建时间
     */
    @Column(name = "creationDate")
    private Date creationdate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    @Column(name = "modifyBy")
    private Long modifyby;

    /**
     * 最新更新时间
     */
    @Column(name = "modifyDate")
    private Date modifydate;

    /**
     * apk文件的服务器存储路径
     */
    @Column(name = "apkLocPath")
    private String apklocpath;

    /**
     * 上传的apk文件名称
     */
    @Column(name = "apkFileName")
    private String apkfilename;


}