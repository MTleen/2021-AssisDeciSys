package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 四级标签对象 Label4
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public class Label4 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签编号 */
    private Long labelid;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String labelname;

    public void setLabelid(Long labelid) 
    {
        this.labelid = labelid;
    }

    public Long getLabelid() 
    {
        return labelid;
    }
    public void setLabelname(String labelname) 
    {
        this.labelname = labelname;
    }

    public String getLabelname() 
    {
        return labelname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("labelid", getLabelid())
            .append("labelname", getLabelname())
            .toString();
    }
}
