package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 险情类型对象 DisasterType
 * 
 * @author Mathripper
 * @date 2021-10-14
 */
public class DisasterType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long typeid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String typename;

    public void setTypeid(Long typeid) 
    {
        this.typeid = typeid;
    }

    public Long getTypeid() 
    {
        return typeid;
    }
    public void setTypename(String typename) 
    {
        this.typename = typename;
    }

    public String getTypename() 
    {
        return typename;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeid", getTypeid())
            .append("typename", getTypename())
            .toString();
    }
}
