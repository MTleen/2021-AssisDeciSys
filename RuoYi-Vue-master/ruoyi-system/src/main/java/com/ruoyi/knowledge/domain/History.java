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
    private String informid;

    /** 岗位编号 */
    @Excel(name = "岗位编号")
    private String positionid;

    /** 发送时间 */
    @Excel(name = "发送时间")
    private String sendtime;

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

    public void setpositionid(String positionid) 
    {
        this.positionid = positionid;
    }
    public String getpositionid() 
    {
        return positionid;
    }

    public void setsendtime(String sendtime) 
    {
        this.sendtime = sendtime;
    }
    public String getsendtime() 
    {
        return sendtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("index", getIndex())
            .append("cautionid", getCautionid())
            .append("informid", getInformid())
            .append("positionid", getpositionid())
            .append("sendtime", getsendtime())
            .toString();
    }
}
