package com.ruoyi.knowledge.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出警记录表对象 Record
 *
 * @author Mathripper
 * @date 2021-11-10
 */
public class Record extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 报警编号
     */
    private String cautionid;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date cautiontime;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cautiontimeStart;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cautiontimeEnd;

    /**
     * 地址
     */
    @Excel(name = "地址")
    private String location;

    /**
     * 险情类型
     */
    @Excel(name = "险情类型")
    private Long distypeid;

    /**
     * 处置对象
     */
    @Excel(name = "处置对象")
    private Long dillobject;

    /**
     * 主管单位
     */
    @Excel(name = "主管单位")
    private Long siteid;

    /**
     * 出警车辆
     */
    @Excel(name = "出警车辆")
    private Integer truckid;

    /**
     *
     */
    private Long detailtype;

    /**
     * 图片
     */
    private String picture;

    /**
     * $column.columnComment
     */
    private Long label4;

    /**
     * 任务执行状态
     */
    @Excel(name = "任务执行状态")
    private Integer status;

    /**
     * $column.columnComment
     */
    @Excel(name = "任务执行状态")
    private String keywords;

    /**
     * 参战力量
     */
    @Excel(name = "参战力量")
    private String siteid2;

    /**
     * 类型
     */
    @Excel(name = "类型")
    private Integer librarytype;

    public void setCautionid(String cautionid) {
        this.cautionid = cautionid;
    }

    public String getCautionid() {
        return cautionid;
    }

    public void setCautiontime(Date cautiontime) {
        this.cautiontime = cautiontime;
    }

    public Date getCautiontime() {
        return cautiontime;
    }

    public Date getCautiontimeStart() {
        return cautiontimeStart;
    }

    public void setCautiontimeStart(Date cautiontime) {
        this.cautiontimeStart = cautiontime;
    }

    public void setCautiontimeEnd(Date cautiontime) {
        this.cautiontimeEnd = cautiontime;
    }

    public Date getCautiontimeEnd() {
        return cautiontimeEnd;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setDistypeid(Long distypeid) {
        this.distypeid = distypeid;
    }

    public Long getDistypeid() {
        return distypeid;
    }

    public void setDillobject(Long dillobject) {
        this.dillobject = dillobject;
    }

    public Long getDillobject() {
        return dillobject;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    public Long getSiteid() {
        return siteid;
    }

    public void setTruckid(Integer truckid) {
        this.truckid = truckid;
    }

    public Integer getTruckid() {
        return truckid;
    }

    public void setDetailtype(Long detailtype) {
        this.detailtype = detailtype;
    }

    public Long getDetailtype() {
        return detailtype;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setLabel4(Long label4) {
        this.label4 = label4;
    }

    public Long getLabel4() {
        return label4;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setSiteid2(String siteid2) {
        this.siteid2 = siteid2;
    }

    public String getSiteid2() {
        return siteid2;
    }

    public void setLibrarytype(Integer librarytype) {
        this.librarytype = librarytype;
    }

    public Integer getLibrarytype() {
        return librarytype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("cautionid", getCautionid())
                .append("cautiontime", getCautiontime())
                .append("location", getLocation())
                .append("distypeid", getDistypeid())
                .append("dillobject", getDillobject())
                .append("siteid", getSiteid())
                .append("truckid", getTruckid())
                .append("detailtype", getDetailtype())
                .append("picture", getPicture())
                .append("label4", getLabel4())
                .append("status", getStatus())
                .append("keywords", getKeywords())
                .append("siteid2", getSiteid2())
                .append("librarytype", getLibrarytype())
                .toString();
    }
}