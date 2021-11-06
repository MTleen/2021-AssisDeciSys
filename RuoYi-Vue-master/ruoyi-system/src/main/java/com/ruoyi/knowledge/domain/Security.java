package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 安全知识库对象 Security
 * 
 * @author Mathripper
 * @date 2021-11-06
 */
public class Security extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer informid;

    /** 提示信息 */
    @Excel(name = "提示信息")
    private String inform;

    /** 安全类型 */
    @Excel(name = "安全类型")
    private Long securitypeid;

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
    public void setSecuritypeid(Long securitypeid) 
    {
        this.securitypeid = securitypeid;
    }

    public Long getSecuritypeid() 
    {
        return securitypeid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("informid", getInformid())
            .append("inform", getInform())
            .append("securitypeid", getSecuritypeid())
            .toString();
    }
}
