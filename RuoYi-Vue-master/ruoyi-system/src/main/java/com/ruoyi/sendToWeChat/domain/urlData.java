package com.ruoyi.sendToWeChat.domain;


import lombok.Data;

/*
 *  @author:xy
 * */
@Data
public class urlData {
    String corpid;
    String corpsecret;
    String Get_Token_Url;
    String SendMessage_Url;

    public void setGet_Token_Url(String corpid,String corpsecret) {
        this.Get_Token_Url ="https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+corpsecret;
    }
    public String getGet_Token_Url() {
        return Get_Token_Url;
    }
    public String getSendMessage_Url() {
        SendMessage_Url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
        return SendMessage_Url;
    }

}
