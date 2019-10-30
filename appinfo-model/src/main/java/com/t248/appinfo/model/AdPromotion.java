package com.t248.appinfo.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
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
    @Column(name = "appId")
    private Long appid;

    /**
     * 广告图片存储路径
     */
    @Column(name = "adPicPath")
    private String adpicpath;

    /**
     * 广告点击量
     */
    @Column(name = "adPV")
    private Long adpv;

    /**
     * 轮播位（1-n）
     */
    @Column(name = "carouselPosition")
    private Integer carouselposition;

    /**
     * 起效时间
     */
    @Column(name = "startTime")
    private Date starttime;

    /**
     * 失效时间
     */
    @Column(name = "endTime")
    private Date endtime;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    @Column(name = "createdBy")
    private Long createdby;

    /**
     * 创建时间
     */
    @Column(name = "creationDate")
    private Date creationdate;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    @Column(name = "modifyBy")
    private Long modifyby;

    /**
     * 最新更新时间
     */
    @Column(name = "modifyDate")
    private Date modifydate;


}