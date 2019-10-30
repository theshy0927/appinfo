package com.t248.appinfo.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "dev_user")
public class DevUser {
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
    private String devcode;

    /**
     * 开发者名称
     */
    @Column(name = "devName")
    private String devname;

    /**
     * 开发者密码
     */
    @Column(name = "devPassword")
    private String devpassword;

    /**
     * 开发者电子邮箱
     */
    @Column(name = "devEmail")
    private String devemail;

    /**
     * 开发者简介
     */
    @Column(name = "devInfo")
    private String devinfo;

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