package com.t248.appinfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private String typeCode;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型值ID
     */
    private Long valueId;

    /**
     * 类型值Name
     */
    private String valueName;

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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取类型编码
     *
     * @return typeCode - 类型编码
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 设置类型编码
     *
     * @param typeCode 类型编码
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    /**
     * 获取类型名称
     *
     * @return typeName - 类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置类型名称
     *
     * @param typeName 类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 获取类型值ID
     *
     * @return valueId - 类型值ID
     */
    public Long getValueId() {
        return valueId;
    }

    /**
     * 设置类型值ID
     *
     * @param valueId 类型值ID
     */
    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    /**
     * 获取类型值Name
     *
     * @return valueName - 类型值Name
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * 设置类型值Name
     *
     * @param valueName 类型值Name
     */
    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
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