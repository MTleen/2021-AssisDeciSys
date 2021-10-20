package com.ruoyi.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.UserPositionMapper;
import com.ruoyi.information.domain.UserPosition;
import com.ruoyi.information.service.IUserPositionService;

/**
 * 岗位信息表管理Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
@Service
public class UserPositionServiceImpl implements IUserPositionService 
{
    @Autowired
    private UserPositionMapper userPositionMapper;

    /**
     * 查询岗位信息表管理
     * 
     * @param positionid 岗位信息表管理主键
     * @return 岗位信息表管理
     */
    @Override
    public UserPosition selectUserPositionByPositionid(Long positionid)
    {
        return userPositionMapper.selectUserPositionByPositionid(positionid);
    }

    /**
     * 查询岗位信息表管理列表
     * 
     * @param userPosition 岗位信息表管理
     * @return 岗位信息表管理
     */
    @Override
    public List<UserPosition> selectUserPositionList(UserPosition userPosition)
    {
        return userPositionMapper.selectUserPositionList(userPosition);
    }

    /**
     * 新增岗位信息表管理
     * 
     * @param userPosition 岗位信息表管理
     * @return 结果
     */
    @Override
    public int insertUserPosition(UserPosition userPosition)
    {
        return userPositionMapper.insertUserPosition(userPosition);
    }

    /**
     * 修改岗位信息表管理
     * 
     * @param userPosition 岗位信息表管理
     * @return 结果
     */
    @Override
    public int updateUserPosition(UserPosition userPosition)
    {
        return userPositionMapper.updateUserPosition(userPosition);
    }

    /**
     * 批量删除岗位信息表管理
     * 
     * @param positionids 需要删除的岗位信息表管理主键
     * @return 结果
     */
    @Override
    public int deleteUserPositionByPositionids(Long[] positionids)
    {
        return userPositionMapper.deleteUserPositionByPositionids(positionids);
    }

    /**
     * 删除岗位信息表管理信息
     * 
     * @param positionid 岗位信息表管理主键
     * @return 结果
     */
    @Override
    public int deleteUserPositionByPositionid(Long positionid)
    {
        return userPositionMapper.deleteUserPositionByPositionid(positionid);
    }
}
