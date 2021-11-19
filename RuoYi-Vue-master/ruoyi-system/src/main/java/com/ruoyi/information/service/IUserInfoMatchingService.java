package com.ruoyi.information.service;

import com.ruoyi.information.domain.UserInfo;

/**
 *  @author:xy
 * */
public interface IUserInfoMatchingService {
    /**
     *
     * @param openid openid
     * @return userid
     */
    public String selectUserIDbyOpenID(String openid);
}
