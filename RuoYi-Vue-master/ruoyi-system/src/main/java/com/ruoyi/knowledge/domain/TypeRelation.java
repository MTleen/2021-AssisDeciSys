package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标签关系对象 TypeRelation
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
public class TypeRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long disposeobj;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long detailtype;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDisposeobj(Long disposeobj) 
    {
        this.disposeobj = disposeobj;
    }

    public Long getDisposeobj() 
    {
        return disposeobj;
    }
    public void setDetailtype(Long detailtype) 
    {
        this.detailtype = detailtype;
    }

    public Long getDetailtype() 
    {
        return detailtype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("disposeobj", getDisposeobj())
            .append("detailtype", getDetailtype())
            .toString();
    }
}
