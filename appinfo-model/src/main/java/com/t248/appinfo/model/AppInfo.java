package com.t248.appinfo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "app_info")
public class AppInfo {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 软件名称
     */
    @Column(name = "softwareName")
    private String softwarename;

    /**
     * APK名称（唯一）
     */
    @Column(name = "APKName")
    private String apkname;

    /**
     * 支持ROM
     */
    @Column(name = "supportROM")
    private String supportrom;

    /**
     * 界面语言
     */
    @Column(name = "interfaceLanguage")
    private String interfacelanguage;

    /**
     * 软件大小（单位：M）
     */
    @Column(name = "softwareSize")
    private BigDecimal softwaresize;

    /**
     * 更新日期
     */
    @Column(name = "updateDate")
    private Date updatedate;

    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    @Column(name = "devId")
    private Long devid;

    /**
     * 应用简介
     */
    @Column(name = "appInfo")
    private String appinfo;

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    private Long status;

    /**
     * 上架时间
     */
    @Column(name = "onSaleDate")
    private Date onsaledate;

    /**
     * 下架时间
     */
    @Column(name = "offSaleDate")
    private Date offsaledate;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    @Column(name = "flatformId")
    private Long flatformid;

    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    @Column(name = "categoryLevel3")
    private Long categorylevel3;

    /**
     * 下载量（单位：次）
     */
    private Long downloads;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    @Column(name = "createdBy")
    private Long createdby;

    /**
     * 创建时间
     */
    @Column(name = "creationDate")
    private Date creationdate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    @Column(name = "modifyBy")
    private Long modifyby;

    /**
     * 最新更新时间
     */
    @Column(name = "modifyDate")
    private Date modifydate;

    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    @Column(name = "categoryLevel1")
    private Long categorylevel1;

    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    @Column(name = "categoryLevel2")
    private Long categorylevel2;

    /**
     * LOGO图片url路径
     */
    @Column(name = "logoPicPath")
    private String logopicpath;

    /**
     * LOGO图片的服务器存储路径
     */
    @Column(name = "logoLocPath")
    private String logolocpath;

    /**
     * 最新的版本id
     */
    @Column(name = "versionId")
    private Long versionid;

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
     * 获取软件名称
     *
     * @return softwareName - 软件名称
     */
    public String getSoftwarename() {
        return softwarename;
    }

    /**
     * 设置软件名称
     *
     * @param softwarename 软件名称
     */
    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename == null ? null : softwarename.trim();
    }

    /**
     * 获取APK名称（唯一）
     *
     * @return APKName - APK名称（唯一）
     */
    public String getApkname() {
        return apkname;
    }

    /**
     * 设置APK名称（唯一）
     *
     * @param apkname APK名称（唯一）
     */
    public void setApkname(String apkname) {
        this.apkname = apkname == null ? null : apkname.trim();
    }

    /**
     * 获取支持ROM
     *
     * @return supportROM - 支持ROM
     */
    public String getSupportrom() {
        return supportrom;
    }

    /**
     * 设置支持ROM
     *
     * @param supportrom 支持ROM
     */
    public void setSupportrom(String supportrom) {
        this.supportrom = supportrom == null ? null : supportrom.trim();
    }

    /**
     * 获取界面语言
     *
     * @return interfaceLanguage - 界面语言
     */
    public String getInterfacelanguage() {
        return interfacelanguage;
    }

    /**
     * 设置界面语言
     *
     * @param interfacelanguage 界面语言
     */
    public void setInterfacelanguage(String interfacelanguage) {
        this.interfacelanguage = interfacelanguage == null ? null : interfacelanguage.trim();
    }

    /**
     * 获取软件大小（单位：M）
     *
     * @return softwareSize - 软件大小（单位：M）
     */
    public BigDecimal getSoftwaresize() {
        return softwaresize;
    }

    /**
     * 设置软件大小（单位：M）
     *
     * @param softwaresize 软件大小（单位：M）
     */
    public void setSoftwaresize(BigDecimal softwaresize) {
        this.softwaresize = softwaresize;
    }

    /**
     * 获取更新日期
     *
     * @return updateDate - 更新日期
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置更新日期
     *
     * @param updatedate 更新日期
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取开发者id（来源于：dev_user表的开发者id）
     *
     * @return devId - 开发者id（来源于：dev_user表的开发者id）
     */
    public Long getDevid() {
        return devid;
    }

    /**
     * 设置开发者id（来源于：dev_user表的开发者id）
     *
     * @param devid 开发者id（来源于：dev_user表的开发者id）
     */
    public void setDevid(Long devid) {
        this.devid = devid;
    }

    /**
     * 获取应用简介
     *
     * @return appInfo - 应用简介
     */
    public String getAppinfo() {
        return appinfo;
    }

    /**
     * 设置应用简介
     *
     * @param appinfo 应用简介
     */
    public void setAppinfo(String appinfo) {
        this.appinfo = appinfo == null ? null : appinfo.trim();
    }

    /**
     * 获取状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     *
     * @return status - 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     *
     * @param status 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * 获取上架时间
     *
     * @return onSaleDate - 上架时间
     */
    public Date getOnsaledate() {
        return onsaledate;
    }

    /**
     * 设置上架时间
     *
     * @param onsaledate 上架时间
     */
    public void setOnsaledate(Date onsaledate) {
        this.onsaledate = onsaledate;
    }

    /**
     * 获取下架时间
     *
     * @return offSaleDate - 下架时间
     */
    public Date getOffsaledate() {
        return offsaledate;
    }

    /**
     * 设置下架时间
     *
     * @param offsaledate 下架时间
     */
    public void setOffsaledate(Date offsaledate) {
        this.offsaledate = offsaledate;
    }

    /**
     * 获取所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     *
     * @return flatformId - 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    public Long getFlatformid() {
        return flatformid;
    }

    /**
     * 设置所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     *
     * @param flatformid 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    public void setFlatformid(Long flatformid) {
        this.flatformid = flatformid;
    }

    /**
     * 获取所属三级分类（来源于：data_dictionary）
     *
     * @return categoryLevel3 - 所属三级分类（来源于：data_dictionary）
     */
    public Long getCategorylevel3() {
        return categorylevel3;
    }

    /**
     * 设置所属三级分类（来源于：data_dictionary）
     *
     * @param categorylevel3 所属三级分类（来源于：data_dictionary）
     */
    public void setCategorylevel3(Long categorylevel3) {
        this.categorylevel3 = categorylevel3;
    }

    /**
     * 获取下载量（单位：次）
     *
     * @return downloads - 下载量（单位：次）
     */
    public Long getDownloads() {
        return downloads;
    }

    /**
     * 设置下载量（单位：次）
     *
     * @param downloads 下载量（单位：次）
     */
    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    /**
     * 获取创建者（来源于dev_user开发者信息表的用户id）
     *
     * @return createdBy - 创建者（来源于dev_user开发者信息表的用户id）
     */
    public Long getCreatedby() {
        return createdby;
    }

    /**
     * 设置创建者（来源于dev_user开发者信息表的用户id）
     *
     * @param createdby 创建者（来源于dev_user开发者信息表的用户id）
     */
    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    /**
     * 获取创建时间
     *
     * @return creationDate - 创建时间
     */
    public Date getCreationdate() {
        return creationdate;
    }

    /**
     * 设置创建时间
     *
     * @param creationdate 创建时间
     */
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    /**
     * 获取更新者（来源于dev_user开发者信息表的用户id）
     *
     * @return modifyBy - 更新者（来源于dev_user开发者信息表的用户id）
     */
    public Long getModifyby() {
        return modifyby;
    }

    /**
     * 设置更新者（来源于dev_user开发者信息表的用户id）
     *
     * @param modifyby 更新者（来源于dev_user开发者信息表的用户id）
     */
    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    /**
     * 获取最新更新时间
     *
     * @return modifyDate - 最新更新时间
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     * 设置最新更新时间
     *
     * @param modifydate 最新更新时间
     */
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    /**
     * 获取所属一级分类（来源于：data_dictionary）
     *
     * @return categoryLevel1 - 所属一级分类（来源于：data_dictionary）
     */
    public Long getCategorylevel1() {
        return categorylevel1;
    }

    /**
     * 设置所属一级分类（来源于：data_dictionary）
     *
     * @param categorylevel1 所属一级分类（来源于：data_dictionary）
     */
    public void setCategorylevel1(Long categorylevel1) {
        this.categorylevel1 = categorylevel1;
    }

    /**
     * 获取所属二级分类（来源于：data_dictionary）
     *
     * @return categoryLevel2 - 所属二级分类（来源于：data_dictionary）
     */
    public Long getCategorylevel2() {
        return categorylevel2;
    }

    /**
     * 设置所属二级分类（来源于：data_dictionary）
     *
     * @param categorylevel2 所属二级分类（来源于：data_dictionary）
     */
    public void setCategorylevel2(Long categorylevel2) {
        this.categorylevel2 = categorylevel2;
    }

    /**
     * 获取LOGO图片url路径
     *
     * @return logoPicPath - LOGO图片url路径
     */
    public String getLogopicpath() {
        return logopicpath;
    }

    /**
     * 设置LOGO图片url路径
     *
     * @param logopicpath LOGO图片url路径
     */
    public void setLogopicpath(String logopicpath) {
        this.logopicpath = logopicpath == null ? null : logopicpath.trim();
    }

    /**
     * 获取LOGO图片的服务器存储路径
     *
     * @return logoLocPath - LOGO图片的服务器存储路径
     */
    public String getLogolocpath() {
        return logolocpath;
    }

    /**
     * 设置LOGO图片的服务器存储路径
     *
     * @param logolocpath LOGO图片的服务器存储路径
     */
    public void setLogolocpath(String logolocpath) {
        this.logolocpath = logolocpath == null ? null : logolocpath.trim();
    }

    /**
     * 获取最新的版本id
     *
     * @return versionId - 最新的版本id
     */
    public Long getVersionid() {
        return versionid;
    }

    /**
     * 设置最新的版本id
     *
     * @param versionid 最新的版本id
     */
    public void setVersionid(Long versionid) {
        this.versionid = versionid;
    }
}