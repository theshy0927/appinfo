package com.t248.appinfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private String categoryCode;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 父级节点id
     */
    private Long parentId;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private Date creationTime;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Long modifyBy;

    /**
     * 最新更新时间
     */
    private Date modifyDate;

    private Integer catelevel;

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
     * 获取分类编码
     *
     * @return categoryCode - 分类编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 设置分类编码
     *
     * @param categoryCode 分类编码
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    /**
     * 获取分类名称
     *
     * @return categoryName - 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取父级节点id
     *
     * @return parentId - 父级节点id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级节点id
     *
     * @param parentId 父级节点id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * @return creationTime - 创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * 设置创建时间
     *
     * @param creationTime 创建时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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
     * @return catelevel
     */
    public Integer getCatelevel() {
        return catelevel;
    }

    /**
     * @param catelevel
     */
    public void setCatelevel(Integer catelevel) {
        this.catelevel = catelevel;
    }
}