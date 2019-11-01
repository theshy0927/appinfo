package com.t248.appinfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

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
    private Long appId;

    /**
     * 版本号
     */
    private String versionNo;

    /**
     * 版本介绍
     */
    private String versionInfo;

    /**
     * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    private Long publishStatus;

    /**
     * 下载链接
     */
    private String downloadLink;

    /**
     * 版本大小（单位：M）
     */
    private BigDecimal versionSize;

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
     * apk文件的服务器存储路径
     */
    private String apkLocPath;

    /**
     * 上传的apk文件名称
     */
    private String apkFileName;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取appId（来源于：app_info表的主键id）
     *
     * @return appId - appId（来源于：app_info表的主键id）
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置appId（来源于：app_info表的主键id）
     *
     * @param appId appId（来源于：app_info表的主键id）
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取版本号
     *
     * @return versionNo - 版本号
     */
    public String getVersionNo() {
        return versionNo;
    }

    /**
     * 设置版本号
     *
     * @param versionNo 版本号
     */
    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo == null ? null : versionNo.trim();
    }

    /**
     * 获取版本介绍
     *
     * @return versionInfo - 版本介绍
     */
    public String getVersionInfo() {
        return versionInfo;
    }

    /**
     * 设置版本介绍
     *
     * @param versionInfo 版本介绍
     */
    public void setVersionInfo(String versionInfo) {
        this.versionInfo = versionInfo == null ? null : versionInfo.trim();
    }

    /**
     * 获取发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     *
     * @return publishStatus - 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    public Long getPublishStatus() {
        return publishStatus;
    }

    /**
     * 设置发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     *
     * @param publishStatus 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    public void setPublishStatus(Long publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 获取下载链接
     *
     * @return downloadLink - 下载链接
     */
    public String getDownloadLink() {
        return downloadLink;
    }

    /**
     * 设置下载链接
     *
     * @param downloadLink 下载链接
     */
    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink == null ? null : downloadLink.trim();
    }

    /**
     * 获取版本大小（单位：M）
     *
     * @return versionSize - 版本大小（单位：M）
     */
    public BigDecimal getVersionSize() {
        return versionSize;
    }

    /**
     * 设置版本大小（单位：M）
     *
     * @param versionSize 版本大小（单位：M）
     */
    public void setVersionSize(BigDecimal versionSize) {
        this.versionSize = versionSize;
    }

    /**
     * 获取创建者（来源于dev_user开发者信息表的用户id）
     *
     * @return createdBy - 创建者（来源于dev_user开发者信息表的用户id）
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建者（来源于dev_user开发者信息表的用户id）
     *
     * @param createdBy 创建者（来源于dev_user开发者信息表的用户id）
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取创建时间
     *
     * @return creationDate - 创建时间
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * 设置创建时间
     *
     * @param creationDate 创建时间
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 获取更新者（来源于dev_user开发者信息表的用户id）
     *
     * @return modifyBy - 更新者（来源于dev_user开发者信息表的用户id）
     */
    public Long getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置更新者（来源于dev_user开发者信息表的用户id）
     *
     * @param modifyBy 更新者（来源于dev_user开发者信息表的用户id）
     */
    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 获取最新更新时间
     *
     * @return modifyDate - 最新更新时间
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 设置最新更新时间
     *
     * @param modifyDate 最新更新时间
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * 获取apk文件的服务器存储路径
     *
     * @return apkLocPath - apk文件的服务器存储路径
     */
    public String getApkLocPath() {
        return apkLocPath;
    }

    /**
     * 设置apk文件的服务器存储路径
     *
     * @param apkLocPath apk文件的服务器存储路径
     */
    public void setApkLocPath(String apkLocPath) {
        this.apkLocPath = apkLocPath == null ? null : apkLocPath.trim();
    }

    /**
     * 获取上传的apk文件名称
     *
     * @return apkFileName - 上传的apk文件名称
     */
    public String getApkFileName() {
        return apkFileName;
    }

    /**
     * 设置上传的apk文件名称
     *
     * @param apkFileName 上传的apk文件名称
     */
    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName == null ? null : apkFileName.trim();
    }
}