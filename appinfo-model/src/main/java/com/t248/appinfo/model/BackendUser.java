package com.t248.appinfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
     */
    private Long userType;

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
     * 用户密码
     */
    private String userPassword;

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
     * 获取用户编码
     *
     * @return userCode - 用户编码
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置用户编码
     *
     * @param userCode 用户编码
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 获取用户名称
     *
     * @return userName - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
     *
     * @return userType - 用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
     */
    public Long getUserType() {
        return userType;
    }

    /**
     * 设置用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
     *
     * @param userType 用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
     */
    public void setUserType(Long userType) {
        this.userType = userType;
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

    /**
     * 获取用户密码
     *
     * @return userPassword - 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置用户密码
     *
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
}