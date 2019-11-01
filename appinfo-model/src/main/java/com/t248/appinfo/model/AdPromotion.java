package com.t248.appinfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ad_promotion")
public class AdPromotion {
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
     * 广告图片存储路径
     */
    private String adPicPath;

    /**
     * 广告点击量
     */
    private Long adPV;

    /**
     * 轮播位（1-n）
     */
    private Integer carouselPosition;

    /**
     * 起效时间
     */
    private Date startTime;

    /**
     * 失效时间
     */
    private Date endTime;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Long modifyBy;

    /**
     * 最新更新时间
     */
    private Date modifyDate;

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
     * 获取广告图片存储路径
     *
     * @return adPicPath - 广告图片存储路径
     */
    public String getAdPicPath() {
        return adPicPath;
    }

    /**
     * 设置广告图片存储路径
     *
     * @param adPicPath 广告图片存储路径
     */
    public void setAdPicPath(String adPicPath) {
        this.adPicPath = adPicPath == null ? null : adPicPath.trim();
    }

    /**
     * 获取广告点击量
     *
     * @return adPV - 广告点击量
     */
    public Long getAdPV() {
        return adPV;
    }

    /**
     * 设置广告点击量
     *
     * @param adPV 广告点击量
     */
    public void setAdPV(Long adPV) {
        this.adPV = adPV;
    }

    /**
     * 获取轮播位（1-n）
     *
     * @return carouselPosition - 轮播位（1-n）
     */
    public Integer getCarouselPosition() {
        return carouselPosition;
    }

    /**
     * 设置轮播位（1-n）
     *
     * @param carouselPosition 轮播位（1-n）
     */
    public void setCarouselPosition(Integer carouselPosition) {
        this.carouselPosition = carouselPosition;
    }

    /**
     * 获取起效时间
     *
     * @return startTime - 起效时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置起效时间
     *
     * @param startTime 起效时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取失效时间
     *
     * @return endTime - 失效时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置失效时间
     *
     * @param endTime 失效时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取创建者（来源于backend_user用户表的用户id）
     *
     * @return createdBy - 创建者（来源于backend_user用户表的用户id）
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建者（来源于backend_user用户表的用户id）
     *
     * @param createdBy 创建者（来源于backend_user用户表的用户id）
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
     * 获取更新者（来源于backend_user用户表的用户id）
     *
     * @return modifyBy - 更新者（来源于backend_user用户表的用户id）
     */
    public Long getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置更新者（来源于backend_user用户表的用户id）
     *
     * @param modifyBy 更新者（来源于backend_user用户表的用户id）
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
}