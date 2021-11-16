package com.ruoyi.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.UserInfoMapper;
import com.ruoyi.information.domain.UserInfo;
import com.ruoyi.information.service.IUserInfoService;

/**
 * 用户信息Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-11-16
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService 
{
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询用户信息
     * 
     * @param tele 用户信息主键
     * @return 用户信息
     */
    @Override
    public UserInfo selectUserInfoByTele(String tele)
    {
        return userInfoMapper.selectUserInfoByTele(tele);
    }

    /**
     * 查询用户信息列表
     * 
     * @param userInfo 用户信息
     * @return 用户信息
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo)
    {
        return userInfoMapper.selectUserInfoList(userInfo);
    }

    /**
     * 新增用户信息
     * 
     * @param userInfo 用户信息
     * @return 结果
     */
    @Override
    public int insertUserInfo(UserInfo userInfo)
    {
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改用户信息
     * 
     * @param userInfo 用户信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo)
    {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 批量删除用户信息
     * 
     * @param teles 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByTeles(String[] teles)
    {
        return userInfoMapper.deleteUserInfoByTeles(teles);
    }

    /**
     * 删除用户信息信息
     * 
     * @param tele 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByTele(String tele)
    {
        return userInfoMapper.deleteUserInfoByTele(tele);
    }
}
