package com.ruoyi.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.TruckTypeMapper;
import com.ruoyi.information.domain.TruckType;
import com.ruoyi.information.service.ITruckTypeService;

/**
 * 消防车类型管理Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
@Service
public class TruckTypeServiceImpl implements ITruckTypeService 
{
    @Autowired
    private TruckTypeMapper truckTypeMapper;

    /**
     * 查询消防车类型管理
     * 
     * @param typeid 消防车类型管理主键
     * @return 消防车类型管理
     */
    @Override
    public TruckType selectTruckTypeByTypeid(Long typeid)
    {
        return truckTypeMapper.selectTruckTypeByTypeid(typeid);
    }

    /**
     * 查询消防车类型管理列表
     * 
     * @param truckType 消防车类型管理
     * @return 消防车类型管理
     */
    @Override
    public List<TruckType> selectTruckTypeList(TruckType truckType)
    {
        return truckTypeMapper.selectTruckTypeList(truckType);
    }

    /**
     * 新增消防车类型管理
     * 
     * @param truckType 消防车类型管理
     * @return 结果
     */
    @Override
    public int insertTruckType(TruckType truckType)
    {
        return truckTypeMapper.insertTruckType(truckType);
    }

    /**
     * 修改消防车类型管理
     * 
     * @param truckType 消防车类型管理
     * @return 结果
     */
    @Override
    public int updateTruckType(TruckType truckType)
    {
        return truckTypeMapper.updateTruckType(truckType);
    }

    /**
     * 批量删除消防车类型管理
     * 
     * @param typeids 需要删除的消防车类型管理主键
     * @return 结果
     */
    @Override
    public int deleteTruckTypeByTypeids(Long[] typeids)
    {
        return truckTypeMapper.deleteTruckTypeByTypeids(typeids);
    }

    /**
     * 删除消防车类型管理信息
     * 
     * @param typeid 消防车类型管理主键
     * @return 结果
     */
    @Override
    public int deleteTruckTypeByTypeid(Long typeid)
    {
        return truckTypeMapper.deleteTruckTypeByTypeid(typeid);
    }
}
