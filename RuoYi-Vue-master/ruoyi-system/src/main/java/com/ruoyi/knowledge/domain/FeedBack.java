package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 反馈表对象 FeedBack
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public class FeedBack extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long feedid;

    /** 人员编号 */
    @Excel(name = "人员编号")
    private String tele;

    /** 反馈信息 */
    @Excel(name = "反馈信息")
    private String inform;

    public void setFeedid(Long feedid) 
    {
        this.feedid = feedid;
    }

    public Long getFeedid() 
    {
        return feedid;
    }
    public void setTele(String tele) 
    {
        this.tele = tele;
    }

    public String getTele() 
    {
        return tele;
    }
    public void setInform(String inform) 
    {
        this.inform = inform;
    }

    public String getInform() 
    {
        return inform;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("feedid", getFeedid())
            .append("tele", getTele())
            .append("inform", getInform())
            .toString();
    }
}
