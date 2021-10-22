package com.ruoyi.information.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消防车信息管理对象 TruckInform
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
public class TruckInform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消防车 ID */
    @Excel(name = "消防车 ID")
    private Integer truckid;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String license;

    /** 所属队站 */
    @Excel(name = "所属队站")
    private Long siteid;

    /** 荷载人数 */
    @Excel(name = "荷载人数")
    private Long peoplenum;

    /** 车状态 */
    @Excel(name = "车状态")
    private Integer truckstate;

    /** 车类型 */
    @Excel(name = "车类型")
    private Long trucktype;

    public void setTruckid(Integer truckid) 
    {
        this.truckid = truckid;
    }

    public Integer getTruckid() 
    {
        return truckid;
    }
    public void setLicense(String license) 
    {
        this.license = license;
    }

    public String getLicense() 
    {
        return license;
    }
    public void setSiteid(Long siteid) 
    {
        this.siteid = siteid;
    }

    public Long getSiteid() 
    {
        return siteid;
    }
    public void setPeoplenum(Long peoplenum) 
    {
        this.peoplenum = peoplenum;
    }

    public Long getPeoplenum() 
    {
        return peoplenum;
    }
    public void setTruckstate(Integer truckstate) 
    {
        this.truckstate = truckstate;
    }

    public Integer getTruckstate() 
    {
        return truckstate;
    }
    public void setTrucktype(Long trucktype) 
    {
        this.trucktype = trucktype;
    }

    public Long getTrucktype() 
    {
        return trucktype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("truckid", getTruckid())
            .append("license", getLicense())
            .append("siteid", getSiteid())
            .append("peoplenum", getPeoplenum())
            .append("truckstate", getTruckstate())
            .append("trucktype", getTrucktype())
            .toString();
    }
}
