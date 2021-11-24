package com.ruoyi.information.mapper;

import com.ruoyi.information.domain.UserInfo;
/**
 *  @author:xy
 * */
public interface UserInfoMatchingMapper {

    /**
     *
     * @param openid openid
     * @return userid
     */
    public String selectUserIDbyOpenID(String openid);
}
