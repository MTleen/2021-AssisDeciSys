package com.ruoyi.information.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 岗位信息表管理对象 UserPosition
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
public class UserPosition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long positionid;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String positionname;

    public void setPositionid(Long positionid) 
    {
        this.positionid = positionid;
    }

    public Long getPositionid() 
    {
        return positionid;
    }
    public void setPositionname(String positionname) 
    {
        this.positionname = positionname;
    }

    public String getPositionname() 
    {
        return positionname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("positionid", getPositionid())
            .append("positionname", getPositionname())
            .toString();
    }
}
