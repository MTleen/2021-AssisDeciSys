package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 历史表对象 History
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public class History
{

    /** 编号 */
    private Long index;

    /** 报警编号 */
    @Excel(name = "报警编号")
    private String cautionid;

    /** 提示信息编号 */
    @Excel(name = "提示信息编号")
    private Long informid;

    public void setIndex(Long index) 
    {
        this.index = index;
    }

    public Long getIndex() 
    {
        return index;
    }
    public void setCautionid(String cautionid) 
    {
        this.cautionid = cautionid;
    }

    public String getCautionid() 
    {
        return cautionid;
    }
    public void setInformid(Long informid) 
    {
        this.informid = informid;
    }

    public Long getInformid() 
    {
        return informid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("index", getIndex())
            .append("cautionid", getCautionid())
            .append("informid", getInformid())
            .toString();
    }
}
