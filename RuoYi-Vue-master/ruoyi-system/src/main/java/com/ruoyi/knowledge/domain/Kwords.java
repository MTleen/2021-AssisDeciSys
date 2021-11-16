package com.ruoyi.knowledge.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
/**
 * 提示信息表对象 Kwords
 * 
 * @author MP5Leader
 * @date 2021-10-19
 */
public class Kwords
{
    static class QueryParameters
    {
        public Long cautionID; // 案件 ID，若为 null 表示该案件为新案件，需要存入 record 表，若不为空，说明是二次推送，不需要存入 record 表
		public String address; // 地址
		public Date date; // 时间
		public Long distype; // 灾情类型（一级标签）
		public Long disposeObj; // 处置对象（二级标签）
		public Long generalType; // 通用类型（通用知识库，三级标签），专项类型和通用类型互斥，只能有一个不为空
		public Long specialType; // 专项类型（专项知识库）
		public Long securityType; // 安全类型（安全知识库）
		public String keyWords; // 关键词
		public Long siteID1; // 主管对站 ID
		public List<Long> siteID2; // 参战对站 IDs，参数为一个 list，每个元素表示一个对战的 ID
    }

    QueryParameters queryParameters;
    List<Kinfo> inform;

    public Kwords()
    {
        this.queryParameters=new QueryParameters();
        this.inform= new ArrayList<Kinfo>();
    }

    public Long getcautionID()
    {
        return this.queryParameters.cautionID;
    }
    public void setcautionID(Long cautionID)
    {
        this.queryParameters.cautionID=cautionID;
    }
    public String getaddress()
    {
        return this.queryParameters.address;
    }
    public void setaddress(String address)
    {
        this.queryParameters.address=address;
    }
    public Date getdate()
    {
        return this.queryParameters.date;
    }
    public void setdate(Date date)
    {
        this.queryParameters.date=date;
    }
    public Long getdistype()
    {
        return this.queryParameters.distype;
    }
    public void setdistype(Long distype)
    {
        this.queryParameters.distype=distype;
    }
    public Long getdisposeObj()
    {
        return this.queryParameters.disposeObj;
    }
    public void setdisposeObj(Long disposeObj)
    {
        this.queryParameters.disposeObj=disposeObj;
    }
    public Long getgeneralType()
    {
        return this.queryParameters.generalType;
    }
    public void setgeneralType(Long generalType)
    {
        this.queryParameters.generalType=generalType;
    }
    public Long getspecialType()
    {
        return this.queryParameters.specialType;
    }
    public void setspecialType(Long specialType)
    {
        this.queryParameters.specialType=specialType;
    }
    public Long getsecurityType()
    {
        return this.queryParameters.securityType;
    }
    public void setsecurityType(Long securityType)
    {
        this.queryParameters.securityType=securityType;
    }
    public String getkeyWords()
    {
        return this.queryParameters.keyWords;
    }
    public void setkeyWords(String keyWords)
    {
        this.queryParameters.keyWords=keyWords;
    }
    public Long getsiteID1()
    {
        return this.queryParameters.siteID1;
    }    
    public void setsiteID1(Long siteID1)
    {
        this.queryParameters.siteID1=siteID1;
    }
    public List<Long> getsiteID2()
    {
        return this.queryParameters.siteID2;
    } 
    public void setsiteID2(List<Long> siteID2)
    {
        this.queryParameters.siteID2=siteID2;
    }

    public List<Kinfo> getinform()
    {
        return this.inform;
    }
    public void setinform(List<Kinfo> inform)
    {
        this.inform=inform;
    }
}