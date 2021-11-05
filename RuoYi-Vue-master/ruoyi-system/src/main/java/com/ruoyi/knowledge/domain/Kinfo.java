package com.ruoyi.knowledge.domain;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 提示信息匹配返回结果类型 Kinfo
 * 
 * @author MP5Leader
 * @date 2021-10-29
 */
public class Kinfo{
      
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
    /** 岗位 */ 
    public String posid;
    /** 每个岗位下的条匹配的提示信息 */ 
    public List<Info> inform;

    public Kinfo(String posid){
        this.posid=posid;
        this.inform= new ArrayList<Info>();
    }

    public void setPosid(String posid) 
    {
        this.posid = posid;
    }
    public String getPosid() 
    {
        return posid;
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
        result.append("posid", getPosid());
        for(Info x:getInform()){
            result.append("infoid", x.getInfoid());
            result.append("text", x.getText());
            result.append("infotype", x.getInfotype());
        }
        return result.toString();
    }
}