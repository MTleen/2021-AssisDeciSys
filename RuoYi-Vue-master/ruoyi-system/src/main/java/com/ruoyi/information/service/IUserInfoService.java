package com.ruoyi.information.service;

import java.util.List;
import com.ruoyi.information.domain.UserInfo;

/**
 * 用户信息Service接口
 * 
 * @author Mathripper
 * @date 2021-11-16
 */
public interface IUserInfoService 
{
    /**
     * 查询用户信息
     * 
     * @param tele 用户信息主键
     * @return 用户信息
     */
    public UserInfo selectUserInfoByTele(String tele);

    /**
     * 查询用户信息列表
     * 
     * @param userInfo 用户信息
     * @return 用户信息集合
     */
    public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 新增用户信息
     * 
     * @param userInfo 用户信息
     * @return 结果
     */
    public int insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户信息
     * 
     * @param userInfo 用户信息
     * @return 结果
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 批量删除用户信息
     * 
     * @param teles 需要删除的用户信息主键集合
     * @return 结果
     */
    public int deleteUserInfoByTeles(String[] teles);

    /**
     * 删除用户信息信息
     * 
     * @param tele 用户信息主键
     * @return 结果
     */
    public int deleteUserInfoByTele(String tele);
}
