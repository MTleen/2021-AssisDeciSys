package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 处置对象对象 DisposeObj
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public class DisposeObj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 处置对象编号 */
    private Long objid;

    /** 处置对象名称 */
    @Excel(name = "处置对象名称")
    private String objname;

    public void setObjid(Long objid) 
    {
        this.objid = objid;
    }

    public Long getObjid() 
    {
        return objid;
    }
    public void setObjname(String objname) 
    {
        this.objname = objname;
    }

    public String getObjname() 
    {
        return objname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("objid", getObjid())
            .append("objname", getObjname())
            .toString();
    }
}
