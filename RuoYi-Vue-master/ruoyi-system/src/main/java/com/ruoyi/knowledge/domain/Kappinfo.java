package com.ruoyi.knowledge.domain;

import java.util.ArrayList;
import java.util.Date;
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
        //        private String infoid;
        private String text;
        private List<String> text1;
        //        private String infotype;
        private Date sendtime;
        //        private String cautionid;
//        private Date cautiontime;
        private String location;
        private String disastertype;
//        private String dillobject;
//        private String picture;
//        private Boolean status;

        public Info(String location,List<String> text1,String disastertype,Date sendtime){
            this.location=location;
            this.text1=text1;
            this.disastertype=disastertype;
            this.sendtime=sendtime;
//            this.picture=picture;
        }

        public void setLocation(String location)
        {
            this.location = location;
        }
        public String getLocation()
        {
            return location;
        }

        public void setText1(List<String> text1)
        {
            this.text1 = text1;
        }
        public List<String> getText1()
        {
            return text1;
        }

        public void setDisastertype(String disastertype)
        {
            this.disastertype = disastertype;
        }
        public String getDisastertype()
        {
            return disastertype;
        }

        public void setSendtime(Date snedtime)
        {
            this.sendtime = sendtime;
        }
        public Date getSendtime()
        {
            return sendtime;
        }

//        public void setPicture(String picture)
//        {
//            this.picture = picture;
//        }
//        public String getPicture()
//        {
//            return picture;
//        }

        @Override
        public String toString() {
            return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                    .append("location", getLocation())
                    .append("text", getText1())
                    .append("disastertype", getDisastertype())
                    .append("sendtime", getSendtime())
//                .append("picture", getPicture())
                    .toString();
        }
    }
    /** 案件记录 */
//    public Record record;
    /** 每个案件记录中发送的提示信息 */
    public List<Info> inform;
//    public String text;

    public Kappinfo(){
//        this.record=new Record();
        this.inform= new ArrayList<Info>();
//        this.text=text;
    }

//    public void setRecord(Record record)
//    {
//        this.record = record;
//    }
//    public Record getRecord()
//    {
//        return record;
//    }

    public List<Info> getInform()
    {
        return inform;
    }

    public void clearInfo()
    {
        this.inform=new ArrayList<Info>();
    }
    public void addInfo(String location, List<String> text1,String disastertype,Date sendtime)
    {
        Info info=new Info(location,text1,disastertype,sendtime);
        this.inform.add(info);
    }

    @Override
    public String toString() {
        ToStringBuilder result=new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE);
//        result.append(record.toString());
        for(Info x:getInform()){
            result.append("location", x.getLocation());
            result.append("text", x.getText1());
            result.append("disastertype", x.getDisastertype());
            result.append("sendtime", x.getSendtime());
//            result.append("picture", x.getPicture());
        }
        return result.toString();
    }
}