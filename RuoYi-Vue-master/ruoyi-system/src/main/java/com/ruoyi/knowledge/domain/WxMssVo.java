package com.ruoyi.knowledge.domain;

import java.util.List;
import java.util.Map;

/*
 * 小程序推送所需数据
 * 编程小石头
 * */
public class WxMssVo {
    private String touser;//用户openid
    private String template_id;//订阅消息模版id
    private String page = "pages/index/index";//默认跳到小程序首页
    private  List<Kappinfo> data;//推送文字

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Kappinfo> getData() {
        return data;
    }

    public void setData(List<Kappinfo> data) {
        this.data = data;
    }
}
