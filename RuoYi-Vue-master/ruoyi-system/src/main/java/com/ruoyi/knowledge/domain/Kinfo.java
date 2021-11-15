package com.ruoyi.knowledge.domain;

/**
 * 决策信息返回元类型 Kinfo
 * 
 * @author MP5Leader
 * @date 2021-10-29
 */
public class Kinfo
{
    public Long informID; // 提示信息ID
    public String inform; // 提示信息内容
    public Long libraryType;

    public Long getinformID()
    {
        return this.informID;
    }
    public void setinformID(Long informID)
    {
        this.informID=informID;
    }
    public String getinform()
    {
        return this.inform;
    }
    public void setinform(String inform)
    {
        this.inform=inform;
    }
    public Long getlibraryType()
    {
        return this.libraryType;
    }
    public void setlibraryType(Long libraryType)
    {
        this.libraryType=libraryType;
    }
}