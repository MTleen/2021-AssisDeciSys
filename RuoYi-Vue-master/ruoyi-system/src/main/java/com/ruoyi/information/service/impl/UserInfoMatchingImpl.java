package com.ruoyi.information.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.UserInfoMatchingMapper;
import com.ruoyi.information.service.IUserInfoMatchingService;

/**
 *  @author:xy
 * */
@Service
public class UserInfoMatchingImpl implements IUserInfoMatchingService {

    @Autowired
    private UserInfoMatchingMapper userInfoMatchingMapper;

    /**
     *
     * @param openid openid
     * @return userid
     */
    @Override
    public String selectUserIDbyOpenID(String openid) {
        return userInfoMatchingMapper.selectUserIDbyOpenID(openid);
    }
}
