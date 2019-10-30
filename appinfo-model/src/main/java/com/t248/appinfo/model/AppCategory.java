package com.t248.appinfo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "app_category")
public class AppCategory {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类编码
     */
    @Column(name = "categoryCode")
    private String categorycode;

    /**
     * 分类名称
     */
    @Column(name = "categoryName")
    private String categoryname;

    /**
     * 父级节点id
     */
    @Column(name = "parentId")
    private Long parentid;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    @Column(name = "createdBy")
    private Long createdby;

    /**
     * 创建时间
     */
    @Column(name = "creationTime")
    private Date creationtime;

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