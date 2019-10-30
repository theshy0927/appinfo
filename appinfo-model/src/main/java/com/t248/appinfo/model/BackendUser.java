package com.t248.appinfo.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "backend_user")
public class BackendUser {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户编码
     */
    @Column(name = "userCode")
    private String usercode;

    /**
     * 用户名称
     */
    @Column(name = "userName")
    private String username;

    /**
     * 用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
     */
    @Column(name = "userType")
    private Long usertype;

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

    /**
     * 用户密码
     */
    @Column(name = "userPassword")
    private String userpassword;


}