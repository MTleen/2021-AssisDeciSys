package com.ruoyi.sendToWeChat.domain;


/*
* author xy
* 用来封装订阅消息内容
*
* */

import lombok.Data;

@Data
public class TemplateData {
    private String value;

    public TemplateData(String value) {
        this.value = value;
    }

}