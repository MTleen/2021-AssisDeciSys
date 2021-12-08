package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 详细类型表对象 DetailType
 *
 * @author Mathripper
 * @date 2021-11-05
 */
public class DetailType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 类型 ID
     */
    private Long typeid;

    /**
     * 类型名称
     */
    @Excel(name = "类型名称")
    private String typename;

    /**
     * 处置对象
     */
    @Excel(name = "处置对象")
    private String disposeobj;

    //    处置对象列表
    private List<String> disposeobjList;
    /**
     * 通用/专项
     */
    @Excel(name = "通用/专项")
    private Long priority;

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypename() {
        return typename;
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

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("typeid", getTypeid())
                .append("typename", getTypename())
                .append("disposeobj", getDisposeobj())
                .append("priority", getPriority())
                .toString();
    }
}