package com.ruoyi.information.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 队站信息对象 Site
 * 
 * @author  Mathripper
 * @date 2021-11-16
 */
public class Site extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long siteid;

    /** 队站 */
    @Excel(name = "队站")
    private String sitename;

    /** 地址 */
    @Excel(name = "地址")
    private String siteposition;

    /** 电话 */
    @Excel(name = "电话")
    private String tele;

    public void setSiteid(Long siteid) 
    {
        this.siteid = siteid;
    }

    public Long getSiteid() 
    {
        return siteid;
    }
    public void setSitename(String sitename) 
    {
        this.sitename = sitename;
    }

    public String getSitename() 
    {
        return sitename;
    }
    public void setSiteposition(String siteposition) 
    {
        this.siteposition = siteposition;
    }

    public String getSiteposition() 
    {
        return siteposition;
    }
    public void setTele(String tele) 
    {
        this.tele = tele;
    }

    public String getTele() 
    {
        return tele;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("siteid", getSiteid())
            .append("sitename", getSitename())
            .append("siteposition", getSiteposition())
            .append("tele", getTele())
            .toString();
    }
}
