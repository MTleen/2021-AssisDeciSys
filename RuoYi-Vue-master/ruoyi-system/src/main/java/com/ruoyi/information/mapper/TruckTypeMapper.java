package com.ruoyi.information.mapper;

import java.util.List;
import com.ruoyi.information.domain.TruckType;

/**
 * 消防车类型管理Mapper接口
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
public interface TruckTypeMapper 
{
    /**
     * 查询消防车类型管理
     * 
     * @param typeid 消防车类型管理主键
     * @return 消防车类型管理
     */
    public TruckType selectTruckTypeByTypeid(Long typeid);

    /**
     * 查询消防车类型管理列表
     * 
     * @param truckType 消防车类型管理
     * @return 消防车类型管理集合
     */
    public List<TruckType> selectTruckTypeList(TruckType truckType);

    /**
     * 新增消防车类型管理
     * 
     * @param truckType 消防车类型管理
     * @return 结果
     */
    public int insertTruckType(TruckType truckType);

    /**
     * 修改消防车类型管理
     * 
     * @param truckType 消防车类型管理
     * @return 结果
     */
    public int updateTruckType(TruckType truckType);

    /**
     * 删除消防车类型管理
     * 
     * @param typeid 消防车类型管理主键
     * @return 结果
     */
    public int deleteTruckTypeByTypeid(Long typeid);

    /**
     * 批量删除消防车类型管理
     * 
     * @param typeids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTruckTypeByTypeids(Long[] typeids);
}
