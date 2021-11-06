package com.ruoyi.common.core.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义字典数据
 * 
 * @author Mathripper
 */
public class DictDataInfo implements Serializable
{
    private static final long serialVersionUID = 2L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> inform;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private List<String> record;

    /**
     * 表格数据对象
     */
    public DictDataInfo()
    {
        this.record = new ArrayList();
        this.record.add("recordInfo_1");
    }

    /**
     * 分页
     *
     * @param list 列表数据
     * @param total 总记录数
     */
    public DictDataInfo(List<?> list, int total)
    {
        this.inform = list;
        this.total = total;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<?> getInform()
    {
        return inform;
    }

    public void setInform(List<?> rows)
    {
        this.inform = rows;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public List getRecord()
    {
        return record;
    }

//    public void setMsg(String msg)
//    {
//        this.record = msg;
//    }
}
