package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 权限管理对象 admin
 * 
 * @author wuliangrui
 * @date 2021-10-14
 */
public class Admin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 权限ID */
    @Excel(name = "权限ID")
    private Long adminid;

    /** 权限 */
    @Excel(name = "权限")
    private String adminname;

    public void setAdminid(Long adminid) 
    {
        this.adminid = adminid;
    }

    public Long getAdminid() 
    {
        return adminid;
    }
    public void setAdminname(String adminname) 
    {
        this.adminname = adminname;
    }

    public String getAdminname() 
    {
        return adminname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("adminid", getAdminid())
            .append("adminname", getAdminname())
            .toString();
    }
}
