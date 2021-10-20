package com.ruoyi.information.service;

import java.util.List;
import com.ruoyi.information.domain.UserPosition;

/**
 * 岗位信息表管理Service接口
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
public interface IUserPositionService 
{
    /**
     * 查询岗位信息表管理
     * 
     * @param positionid 岗位信息表管理主键
     * @return 岗位信息表管理
     */
    public UserPosition selectUserPositionByPositionid(Long positionid);

    /**
     * 查询岗位信息表管理列表
     * 
     * @param userPosition 岗位信息表管理
     * @return 岗位信息表管理集合
     */
    public List<UserPosition> selectUserPositionList(UserPosition userPosition);

    /**
     * 新增岗位信息表管理
     * 
     * @param userPosition 岗位信息表管理
     * @return 结果
     */
    public int insertUserPosition(UserPosition userPosition);

    /**
     * 修改岗位信息表管理
     * 
     * @param userPosition 岗位信息表管理
     * @return 结果
     */
    public int updateUserPosition(UserPosition userPosition);

    /**
     * 批量删除岗位信息表管理
     * 
     * @param positionids 需要删除的岗位信息表管理主键集合
     * @return 结果
     */
    public int deleteUserPositionByPositionids(Long[] positionids);

    /**
     * 删除岗位信息表管理信息
     * 
     * @param positionid 岗位信息表管理主键
     * @return 结果
     */
    public int deleteUserPositionByPositionid(Long positionid);
}
