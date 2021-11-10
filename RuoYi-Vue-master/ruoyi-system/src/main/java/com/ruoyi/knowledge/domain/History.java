package com.ruoyi.knowledge.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 信息历史对象 History
 *
 * @author Mathripper
 * @date 2021-11-06
 */
public class History extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long index;

    /** 案件编号 */
    @Excel(name = "案件编号")
    private String cautionid;

    /** 提示信息 */
    @Excel(name = "提示信息")
    private String informid;

    /** 队站 */
    @Excel(name = "队站")
    private Long positionid;

    /** 推送对象 */
    @Excel(name = "推送对象")
    private String tele;

    /** 发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date sendtime;

    /** 知识类型 */
    @Excel(name = "知识类型")
    private Long librarytype;

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
    public void setPositionid(Long positionid)
    {
        this.positionid = positionid;
    }

    public Long getPositionid()
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
    public void setLibrarytype(Long librarytype)
    {
        this.librarytype = librarytype;
    }

    public Long getLibrarytype()
    {
        return librarytype;
    }

    public void setTele(String tele)
    {
        this.tele = tele;
    }

    public String getTele()
    {
        return tele;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("index", getIndex())
                .append("cautionid", getCautionid())
                .append("informid", getInformid())
                .append("positionid", getPositionid())
                .append("sendtime", getSendtime())
                .append("librarytype", getLibrarytype())
                .toString();
    }
}