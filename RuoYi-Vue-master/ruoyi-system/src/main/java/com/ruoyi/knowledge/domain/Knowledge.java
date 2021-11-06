package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 提示信息表对象 Knowledge
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public class Knowledge
{

    /** 信息编号 */
    private Long informid;


    /** 信息内容 */
    @Excel(name = "信息内容")
    private String inform;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** 险情类型 */
    @Excel(name = "险情类型")
    private String disastertype;

    /** 处置对象 */
    @Excel(name = "处置对象")
    private String disposeobj;

    /** 详细类型 */
    @Excel(name = "详细类型")
    private String detailtype;

    /** 四级标签 */
    @Excel(name = "四级标签")
    private String label4;

    /** 提示信息类型 */
    @Excel(name = "提示信息类型")
    private String informtypeid;

    public void setInformid(Long informid) 
    {
        this.informid = informid;
    }

    public Long getInformid() 
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
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setDisastertype(String disastertype) 
    {
        this.disastertype = disastertype;
    }

    public String getDisastertype() 
    {
        return disastertype;
    }
    public void setDisposeobj(String disposeobj) 
    {
        this.disposeobj = disposeobj;
    }

    public String getDisposeobj() 
    {
        return disposeobj;
    }
    public void setDetailtype(String detailtype) 
    {
        this.detailtype = detailtype;
    }

    public String getDetailtype() 
    {
        return detailtype;
    }
    public void setLabel4(String label4) 
    {
        this.label4 = label4;
    }

    public String getLabel4() 
    {
        return label4;
    }
    public void setInformtypeid(String informtypeid) 
    {
        this.informtypeid = informtypeid;
    }

    public String getInformtypeid() 
    {
        return informtypeid;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("informid", getInformid())
            .append("inform", getInform())
            .append("weight", getWeight())
            .append("disastertype", getDisastertype())
            .append("disposeobj", getDisposeobj())
            .append("detailtype", getDetailtype())
            .append("label4", getLabel4())
            .append("informtypeid", getInformtypeid())
            .toString();
    }
}
