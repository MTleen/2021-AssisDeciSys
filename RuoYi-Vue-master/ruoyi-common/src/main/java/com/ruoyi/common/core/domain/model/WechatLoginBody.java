package com.ruoyi.common.core.domain.model;

//import lombok.Data;
/**
 * 用户微信登录对象
 * 
 * @author Mathripper
 */
//@Data
public class WechatLoginBody
{
    /**
     * 用户手机
     */
    private String tele;

    /**
     * 用户微信 openid
     */
    private String openid;

    public void setTele(String tele){this.tele=tele;}
    public String getTele(){return this.tele;}

    public void setOpenid(String openid){this.openid = openid;}

    public String getOpenid(){return this.openid;}
}
