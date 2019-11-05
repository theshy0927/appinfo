package com.t248.appinfo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "dev_user")
public class DevUser implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 开发者帐号
     */
    @Column(name = "devCode")
    private String devCode;

    /**
     * 开发者名称
     */
    @Column(name = "devName")
    private String devName;

    /**
     * 开发者密码
     */
    @Column(name = "devPassword")
    private String devPassword;

    /**
     * 开发者电子邮箱
     */
    @Column(name = "devEmail")
    private String devEmail;

    /**
     * 开发者简介
     */
    @Column(name = "devInfo")
    private String devInfo;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    @Column(name = "createdBy")
    private Long createdBy;

    /**
     * 创建时间
     */
    @Column(name = "creationDate")
    private Date creationDate;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    @Column(name = "modifyBy")
    private Long modifyBy;

    /**
     * 最新更新时间
     */
    @Column(name = "modifyDate")
    private Date modifyDate;





}