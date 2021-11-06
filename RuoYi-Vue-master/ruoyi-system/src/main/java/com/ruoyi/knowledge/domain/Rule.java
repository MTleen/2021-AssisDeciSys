package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 发送规则对象 Rule
 *
 * @author Mathripper
 * @date 2021-11-06
 */
public class Rule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long ruleid;

    /** 通用数量 */
    @Excel(name = "通用数量")
    private Long generalnum;

    /** 专项数量 */
    @Excel(name = "专项数量")
    private Long securitynum;

    /** 安全数量 */
    @Excel(name = "安全数量")
    private Long specialnum;

    public void setRuleid(Long ruleid)
    {
        this.ruleid = ruleid;
    }

    public Long getRuleid()
    {
        return ruleid;
    }
    public void setGeneralnum(Long generalnum)
    {
        this.generalnum = generalnum;
    }

    public Long getGeneralnum()
    {
        return generalnum;
    }
    public void setSecuritynum(Long securitynum)
    {
        this.securitynum = securitynum;
    }

    public Long getSecuritynum()
    {
        return securitynum;
    }
    public void setSpecialnum(Long specialnum)
    {
        this.specialnum = specialnum;
    }

    public Long getSpecialnum()
    {
        return specialnum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("ruleid", getRuleid())
                .append("generalnum", getGeneralnum())
                .append("securitynum", getSecuritynum())
                .append("specialnum", getSpecialnum())
                .toString();
    }
}