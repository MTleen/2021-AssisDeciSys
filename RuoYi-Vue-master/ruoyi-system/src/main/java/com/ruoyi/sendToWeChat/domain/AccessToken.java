package com.ruoyi.sendToWeChat.domain;


import lombok.Data;

/*
* @author xy
* @description:存储返回的参数
*
* 
* */
@Data
public class AccessToken {
    private String access_token; //获取到的凭证
    private Integer expires_in;  //凭证有效时间
    private Integer errcode;     //错误码
    private String errmsg; //错误信息

}
