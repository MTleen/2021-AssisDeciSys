package com.ruoyi.information.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 用户信息对象 UserInfo
 *
 * @author Mathripper
 * @date 2021-11-16
 */
public class UserInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * $column.columnComment
     */
    private String tele;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String username;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer gender;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date age;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long positionid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer truckid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long siteid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String account;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String password;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long adminid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long status;

    /**
     * 用户微信 openid
     */
    @Excel(name = "用户微信 openid")
    private String openid;

    /**
     * 用户企业微信 id
     */
    @Excel(name = "用户企业微信 id")
    private String userid;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getTele() {
        return tele;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGender() {
        return gender;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public Date getAge() {
        return age;
    }

    public void setPositionid(Long positionid) {
        this.positionid = positionid;
    }

    public Long getPositionid() {
        return positionid;
    }

    public void setTruckid(Integer truckid) {
        this.truckid = truckid;
    }

    public Integer getTruckid() {
        return truckid;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    public Long getSiteid() {
        return siteid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public Long getAdminid() {
        return adminid;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("tele", getTele())
                .append("username", getUsername())
                .append("gender", getGender())
                .append("age", getAge())
                .append("positionid", getPositionid())
                .append("truckid", getTruckid())
                .append("siteid", getSiteid())
                .append("account", getAccount())
                .append("password", getPassword())
                .append("adminid", getAdminid())
                .append("status", getStatus())
                .append("openid", getOpenid())
                .append("userid", getUserid())
                .toString();
    }
}
