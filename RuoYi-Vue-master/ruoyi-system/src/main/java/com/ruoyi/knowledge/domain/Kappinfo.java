package com.ruoyi.knowledge.domain;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * App历史查询返回结果类型 Kappinfo
 * 
 * @author MP5Leader
 * @date 2021-10-31
 */

public class Kappinfo{
      
    static class Info{
        private String infoid;
        private String text;
        private String infotype;

        public Info(String infoid, String text,String infotype){
            this.infoid=infoid;
            this.text=text;
            this.infotype=infotype;
        }

        public void setInfoid(String infoid) 
        {
            this.infoid = infoid;
        }
        public String getInfoid() 
        {
            return infoid;
        }

        public void setText(String text) 
        {
            this.text = text;
        }
        public String getText() 
        {
            return text;
        }

        public void setInfotype(String infotype) 
        {
            this.infotype = infotype;
        }
        public String getInfotype() 
        {
            return infotype;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("infoid", getInfoid())
                .append("text", getText())
                .append("infotype", getInfotype())
                .toString();
        }
    }
    /** 案件记录 */
    public Record record;
    /** 每个案件记录中发送的提示信息 */ 
    public List<Info> inform;

    public Kappinfo(){
        this.record=new Record();
        this.inform= new ArrayList<Info>();
    }

    public void setRecord(Record record) 
    {
        this.record = record;
    }
    public Record getRecord() 
    {
        return record;
    }

    public List<Info> getInform() 
    {
        return inform;
    }

    public void clearInfo() 
    {
        this.inform.clear();
    }
    public void addInfo(String infoid, String text,String infotype) 
    {
        Info info=new Info(infoid,text,infotype);
        this.inform.add(info);
    }

    @Override
    public String toString() {
        ToStringBuilder result=new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE);
        result.append(record.toString());
        for(Info x:getInform()){
            result.append("infoid", x.getInfoid());
            result.append("text", x.getText());
            result.append("infotype", x.getInfotype());
        }
        return result.toString();
    }
}