package com.t248.appinfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "app_category")
public class AppCategory {
    /**
     * 分类ID111
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ·ÖÀà±àÂë
     */
    private String categoryCode;

    /**
     * ·ÖÀàÃû³Æ
     */
    private String categoryName;

    /**
     * ¸¸¼¶½Úµãid
     */
    private Long parentId;

    /**
     * ´´½¨Õß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     */
    private Long createdBy;

    /**
     * ´´½¨Ê±¼ä
     */
    private Date creationTime;

    /**
     * ¸üÐÂÕß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     */
    private Long modifyBy;

    /**
     * ×îÐÂ¸üÐÂÊ±¼ä
     */
    private Date modifyDate;

    private Integer catelevel;

    /**
     * »ñÈ¡Ö÷¼üID
     *
     * @return id - Ö÷¼üID
     */
    public Long getId() {
        return id;
    }

    /**
     * ÉèÖÃÖ÷¼üID
     *
     * @param id Ö÷¼üID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * »ñÈ¡·ÖÀà±àÂë
     *
     * @return categoryCode - ·ÖÀà±àÂë
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * ÉèÖÃ·ÖÀà±àÂë
     *
     * @param categoryCode ·ÖÀà±àÂë
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    /**
     * »ñÈ¡·ÖÀàÃû³Æ
     *
     * @return categoryName - ·ÖÀàÃû³Æ
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * ÉèÖÃ·ÖÀàÃû³Æ
     *
     * @param categoryName ·ÖÀàÃû³Æ
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * »ñÈ¡¸¸¼¶½Úµãid
     *
     * @return parentId - ¸¸¼¶½Úµãid
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * ÉèÖÃ¸¸¼¶½Úµãid
     *
     * @param parentId ¸¸¼¶½Úµãid
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * »ñÈ¡´´½¨Õß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     *
     * @return createdBy - ´´½¨Õß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * ÉèÖÃ´´½¨Õß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     *
     * @param createdBy ´´½¨Õß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * »ñÈ¡´´½¨Ê±¼ä
     *
     * @return creationTime - ´´½¨Ê±¼ä
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * ÉèÖÃ´´½¨Ê±¼ä
     *
     * @param creationTime ´´½¨Ê±¼ä
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * »ñÈ¡¸üÐÂÕß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     *
     * @return modifyBy - ¸üÐÂÕß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     */
    public Long getModifyBy() {
        return modifyBy;
    }

    /**
     * ÉèÖÃ¸üÐÂÕß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     *
     * @param modifyBy ¸üÐÂÕß£¨À´Ô´ÓÚbackend_userÓÃ»§±íµÄÓÃ»§id£©
     */
    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * »ñÈ¡×îÐÂ¸üÐÂÊ±¼ä
     *
     * @return modifyDate - ×îÐÂ¸üÐÂÊ±¼ä
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * ÉèÖÃ×îÐÂ¸üÐÂÊ±¼ä
     *
     * @param modifyDate ×îÐÂ¸üÐÂÊ±¼ä
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