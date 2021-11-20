package com.ruoyi.common.core.domain.model;

public class O2UBody {

    private int errcode;

    private String errmsg;
    private String userid;

    public void setErrcode(int errcode){this.errcode = errcode;}
    public int getErrcode(){return this.errcode;}

    public void setUserid(String userid){this.userid = userid;}
    public String getUserid(){return this.userid;}

    public void setErrmsg(String errmsg){this.errmsg = errmsg;}
    public String getErrmsg(){return this.errmsg;}
}
