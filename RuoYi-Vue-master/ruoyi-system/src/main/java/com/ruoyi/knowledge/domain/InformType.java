package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提示信息类型表对象 InformType
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public class InformType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long typeid;

    /** 名称 */
    @Excel(name = "名称")
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
