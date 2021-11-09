package com.ruoyi.sendToWeChat.domain;

import lombok.Data;

import java.util.Map;

/*
 * xy
 * 小程序推送所需数据
 *
 * */

@Data
public class WxMssVo {
    private String touser;//用户openid
    private String template_id;//订阅消息模版id
    private Map<String, TemplateData> data;//推送文字
}