package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 参战力量对象 ForceInvolve
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
public class ForceInvolve extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long cautionid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long siteid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCautionid(Long cautionid) 
    {
        this.cautionid = cautionid;
    }

    public Long getCautionid() 
    {
        return cautionid;
    }
    public void setSiteid(Long siteid) 
    {
        this.siteid = siteid;
    }

    public Long getSiteid() 
    {
        return siteid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cautionid", getCautionid())
            .append("siteid", getSiteid())
            .toString();
    }
}
