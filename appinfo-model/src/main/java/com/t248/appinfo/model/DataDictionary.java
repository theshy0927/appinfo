package com.t248.appinfo.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "data_dictionary")
public class DataDictionary {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 类型编码
     */
    @Column(name = "typeCode")
    private String typecode;

    /**
     * 类型名称
     */
    @Column(name = "typeName")
    private String typename;

    /**
     * 类型值ID
     */
    @Column(name = "valueId")
    private Long valueid;

    /**
     * 类型值Name
     */
    @Column(name = "valueName")
    private String valuename;

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