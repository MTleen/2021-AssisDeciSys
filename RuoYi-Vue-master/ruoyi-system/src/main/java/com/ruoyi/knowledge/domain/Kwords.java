package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 提示信息表对象 Kwords
 * 
 * @author MP5Leader
 * @date 2021-10-19
 */
public class Kwords
{
    
        /** 险情类型 */
        @Excel(name = "险情类型")
        private Long disastertype;
    
        /** 处置对象 */
        @Excel(name = "处置对象")
        private Long disposeobj;
    
        /** 详细类型 */
        @Excel(name = "详细类型")
        private Long detailtype;

        /** 关键字 */
        @Excel(name = "关键字")
        private String keyword;

    public void setDisastertype(Long disastertype) 
    {
        this.disastertype = disastertype;
    }

    public Long getDisastertype() 
    {
        return disastertype;
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
    public void setkeyword(String keyword) 
    {
        this.keyword = keyword;
    }

    public String getkeyword() 
    {
        return keyword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("disastertype", getDisastertype())
            .append("disposeobj", getDisposeobj())
            .append("detailtype", getDetailtype())
            .append("keyword", getkeyword())
            .toString();
    }
}