package com.ruoyi.sendToWeChat.domain;


import lombok.Data;

/*
* @author:xy
* post请求所需要的数据对象
*/

@Data
public class weChatData {
    //发送微信消息的URL
    //String sendMsgUrl="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
    //对应userid,特殊情况：指定为”@all”，则向该企业应用的全部成员发送,举例："touser" : "UserID1|UserID2|UserID3"
    String touser;
    //消息类型 text
    String msgtype;
    //企业应用的agentid   1000002
    int agentid;
    //消息
    Object text;//实际接收Map类型数据
}
