package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规则表对象 Rule
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public class Rule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 规则编号 */
    private Long ruleid;

    /** 类型编号 */
    @Excel(name = "类型编号")
    private String informtype;

    /** 接收数量 */
    @Excel(name = "接收数量")
    private Long num;

    /** 岗位编号 */
    @Excel(name = "岗位编号")
    private String positionid;

    public void setRuleid(Long ruleid) 
    {
        this.ruleid = ruleid;
    }

    public Long getRuleid() 
    {
        return ruleid;
    }
    public void setInformtype(String informtype) 
    {
        this.informtype = informtype;
    }

    public String getInformtype() 
    {
        return informtype;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setPositionid(String positionid) 
    {
        this.positionid = positionid;
    }

    public String getPositionid() 
    {
        return positionid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ruleid", getRuleid())
            .append("informtype", getInformtype())
            .append("num", getNum())
            .append("positionid", getPositionid())
            .toString();
    }
}
