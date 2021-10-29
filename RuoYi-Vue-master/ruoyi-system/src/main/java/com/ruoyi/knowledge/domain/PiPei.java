package com.ruoyi.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
//
//public class PiPei {
//}


/**
 * 出警记录表对象 Record
 *
 * @author ruoyi
 * @date 2021-10-15
 */
public class PiPei
{
    private static final long serialVersionUID = 1L;

    /** 报警编号 */
    private String cautionid;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cautiontime;

    /** 地址 */
    @Excel(name = "地址")
    private String location;

    /** 险情类型 */
    @Excel(name = "险情类型")
    private Integer distypeid;

    /** 处置对象 */
    @Excel(name = "处置对象")
    private Integer dillobject;

    /** 主管单位 */
    @Excel(name = "主管单位")
    private Integer siteid;

    /** 出警车辆 */
    @Excel(name = "出警车辆")
    private Integer truckid;

    /** 提示信息 */
    @Excel(name = "提示信息")
    private String supplement;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    /** 任务执行状态 */
    @Excel(name = "任务执行状态")
    private Boolean status;

    /** 图片 */
    @Excel(name = "详细类型")
    private Integer detailtype;

    /** 图片 */
    @Excel(name = "四级标签")
    private Integer label4;

    /** 图片 */
    @Excel(name = "关键字")
    private String keywords;

    public void setCautionid(String cautionid)
    {
        this.cautionid = cautionid;
    }

    public String getCautionid()
    {
        return cautionid;
    }
    public void setCautiontime(Date cautiontime)
    {
        this.cautiontime = cautiontime;
    }

    public Date getCautiontime()
    {
        return cautiontime;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }
    public void setDistypeid(Integer distypeid)
    {
        this.distypeid = distypeid;
    }

    public Integer getDistypeid()
    {
        return distypeid;
    }
    public void setDillobject(Integer dillobject)
    {
        this.dillobject = dillobject;
    }

    public Integer getDillobject()
    {
        return dillobject;
    }
    public void setSiteid(Integer siteid)
    {
        this.siteid = siteid;
    }

    public Integer getSiteid()
    {
        return siteid;
    }
    public void setTruckid(Integer truckid)
    {
        this.truckid = truckid;
    }

    public Integer getTruckid()
    {
        return truckid;
    }
    public void setSupplement(String supplement)
    {
        this.supplement = supplement;
    }

    public String getSupplement()
    {
        return supplement;
    }
    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getPicture()
    {
        return picture;
    }
    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setDetailtype(Integer detailtype)
    {
        this.detailtype = detailtype;
    }

    public Integer getDetailtype()
    {
        return detailtype;
    }

    public void setLbel4(Integer label4)
    {
        this.label4 = label4;
    }

    public Integer getLabel4()
    {
        return label4;
    }

    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public String getKeywords()
    {
        return keywords;
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
                .append("supplement", getSupplement())
                .append("picture", getPicture())
                .append("status", getStatus())
                .append("detailtype", getDetailtype())
                .append("label4", getLabel4())
                .append("keywords", getKeywords())
                .toString();
    }
}
