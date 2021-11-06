package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专项知识库对象 Special
 * 
 * @author Mathripper
 * @date 2021-11-06
 */
public class Special extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer informid;

    /** 提示信息 */
    @Excel(name = "提示信息")
    private String inform;

    /** 专项类型 */
    @Excel(name = "专项类型")
    private Long detailtype;

    public void setInformid(Integer informid) 
    {
        this.informid = informid;
    }

    public Integer getInformid() 
    {
        return informid;
    }
    public void setInform(String inform) 
    {
        this.inform = inform;
    }

    public String getInform() 
    {
        return inform;
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
            .append("informid", getInformid())
            .append("inform", getInform())
            .append("detailtype", getDetailtype())
            .toString();
    }
}
