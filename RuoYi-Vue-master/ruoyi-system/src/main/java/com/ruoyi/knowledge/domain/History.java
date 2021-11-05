package com.ruoyi.knowledge.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 历史表对象 History
 *
 * @author xiaoyu
 * @date 2021-10-29
 */
public class History extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long index;

    /** 报警编号 */
    @Excel(name = "报警编号")
    private String cautionid;

    /** 提示信息 */
    @Excel(name = "提示信息")
    private String informid;

    /** 岗位 */
    @Excel(name = "岗位")
    private String positionid;

    /** 发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendtime;

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
    public void setInformid(String informid)
    {
        this.informid = informid;
    }

    public String getInformid()
    {
        return informid;
    }
    public void setPositionid(String positionid)
    {
        this.positionid = positionid;
    }

    public String getPositionid()
    {
        return positionid;
    }
    public void setSendtime(Date sendtime)
    {
        this.sendtime = sendtime;
    }

    public Date getSendtime()
    {
        return sendtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("index", getIndex())
                .append("cautionid", getCautionid())
                .append("informid", getInformid())
                .append("positionid", getPositionid())
                .append("sendtime", getSendtime())
                .toString();
    }
}