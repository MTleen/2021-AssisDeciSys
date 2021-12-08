package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Arrays;
import java.util.List;

/**
 * 通用知识库对象 Knowledge
 *
 * @author Mathripper
 * @date 2021-11-06
 */
public class Knowledge extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long informid;

    private int librarytype = 1;

    /**
     * 信息内容
     */
    @Excel(name = "信息内容")
    private String inform;

    /**
     * 权重
     */
    private Long weight;

    /**
     * 险情类型
     */
    @Excel(name = "灾情类型")
    private String disastertype;

    private List<String> disastertypeList;

    /**
     * 处置对象
     */
    @Excel(name = "处置对象")
    private String disposeobj;

    private List<String> disposeobjList;

    /**
     * 详细类型
     */
    @Excel(name = "详细类型")
    private Long detailtype;

    /**
     * 提示信息类型
     */
    private Long informtypeid;

    /**
     * 关键词
     */
    private String keywords;

    public void setInformid(Long informid) {
        this.informid = informid;
    }

    public Long getInformid() {
        return informid;
    }

    public int getLibrarytype() {
        return librarytype;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    public String getInform() {
        return inform;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWeight() {
        return weight;
    }

    public void setDisastertype(String disastertype) {

        this.disastertype = disastertype;
        if (disastertype != null){
            this.disastertypeList = Arrays.asList(disastertype.split(","));
        }
    }

    public String getDisastertype() {
        return disastertype;
    }

    public void setDisastertypeList(List<String> disastertypeList) {
        this.disastertypeList = disastertypeList;
    }

    public List<String> getDisastertypeList() {
        return disastertypeList;
    }

    public void setDisposeobj(String disposeobj) {

        this.disposeobj = disposeobj;
        if (disposeobj != null){
            this.disposeobjList = Arrays.asList(disposeobj.split(","));
        }
    }

    public String getDisposeobj() {
        return disposeobj;
    }

    public void setDisposeobjList(List<String> disposeobjList) {
        this.disposeobjList = disposeobjList;
    }

    public List<String> getDisposeobjList() {
        return disposeobjList;
    }

    public void setDetailtype(Long detailtype) {
        this.detailtype = detailtype;
    }

    public Long getDetailtype() {
        return detailtype;
    }

    public void setInformtypeid(Long informtypeid) {
        this.informtypeid = informtypeid;
    }

    public Long getInformtypeid() {
        return informtypeid;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("informid", getInformid())
                .append("inform", getInform())
                .append("weight", getWeight())
                .append("disastertype", getDisastertype())
                .append("disposeobj", getDisposeobj())
                .append("detailtype", getDetailtype())
                .append("informtypeid", getInformtypeid())
                .toString();
    }
}