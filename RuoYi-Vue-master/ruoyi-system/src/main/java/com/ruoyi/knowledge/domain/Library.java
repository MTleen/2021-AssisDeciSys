package com.ruoyi.knowledge.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Library {


    /** $column.columnComment */
    private Integer libraryID;

    /** 提示信息 */
    @Excel(name = "名称")
    private String libraryname;

    /** 安全类型 */
    @Excel(name = "类型")
    private String nickname;

    public void setLibraryID(Integer libraryID)
    {
        this.libraryID=libraryID;
    }
    public Integer getLibraryID()
    {
        return libraryID;
    }

    public void setLibraryname(String libraryname)
    {
        this.libraryname = libraryname;
    }
    public String getLibraryname()
    {
        return libraryname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
    public String getNickname()
    {
        return nickname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("informid", getLibraryID())
                .append("inform", getLibraryname())
                .append("securitypeid", getNickname())
                .toString();
    }
}
