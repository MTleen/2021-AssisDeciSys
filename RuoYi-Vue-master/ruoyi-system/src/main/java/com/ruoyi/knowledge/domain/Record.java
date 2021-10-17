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
 * @author ruoyi
 * @date 2021-10-15
 */
public class Record extends BaseEntity
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
    private Long distypeid;

    /** 处置对象 */
    @Excel(name = "处置对象")
    private Long dillobject;

    /** 主管单位 */
    @Excel(name = "主管单位")
    private Long siteid;

    /** 出警车辆 */
    @Excel(name = "出警车辆")
    private Integer truckid;

    /** 提示信息 */
    @Excel(name = "提示信息")
    private String supplement;

    /** 是否存在易燃易爆品 */
    @Excel(name = "是否存在易燃易爆品")
    private Integer boom;

    /** 是否存在有毒物品 */
    @Excel(name = "是否存在有毒物品")
    private Integer poison;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    /** 任务执行状态 */
    @Excel(name = "任务执行状态")
    private Integer status;

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
    public void setDistypeid(Long distypeid) 
    {
        this.distypeid = distypeid;
    }

    public Long getDistypeid() 
    {
        return distypeid;
    }
    public void setDillobject(Long dillobject) 
    {
        this.dillobject = dillobject;
    }

    public Long getDillobject() 
    {
        return dillobject;
    }
    public void setSiteid(Long siteid) 
    {
        this.siteid = siteid;
    }

    public Long getSiteid() 
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
    public void setBoom(Integer boom) 
    {
        this.boom = boom;
    }

    public Integer getBoom() 
    {
        return boom;
    }
    public void setPoison(Integer poison) 
    {
        this.poison = poison;
    }

    public Integer getPoison() 
    {
        return poison;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cautionid", getCautionid())
            .append("cautiontime", getCautiontime())
            .append("location", getLocation())
            .append("distypeid", getDistypeid())
            .append("dillobject", getDillobject())
            .append("siteid", getSiteid())
            .append("truckid", getTruckid())
            .append("supplement", getSupplement())
            .append("boom", getBoom())
            .append("poison", getPoison())
            .append("picture", getPicture())
            .append("status", getStatus())
            .toString();
    }
}
