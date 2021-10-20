package com.ruoyi.information.service;

import java.util.List;
import com.ruoyi.information.domain.TruckInform;

/**
 * 消防车信息管理Service接口
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
public interface ITruckInformService 
{
    /**
     * 查询消防车信息管理
     * 
     * @param license 消防车信息管理主键
     * @return 消防车信息管理
     */
    public TruckInform selectTruckInformByLicense(String license);

    /**
     * 查询消防车信息管理列表
     * 
     * @param truckInform 消防车信息管理
     * @return 消防车信息管理集合
     */
    public List<TruckInform> selectTruckInformList(TruckInform truckInform);

    /**
     * 新增消防车信息管理
     * 
     * @param truckInform 消防车信息管理
     * @return 结果
     */
    public int insertTruckInform(TruckInform truckInform);

    /**
     * 修改消防车信息管理
     * 
     * @param truckInform 消防车信息管理
     * @return 结果
     */
    public int updateTruckInform(TruckInform truckInform);

    /**
     * 批量删除消防车信息管理
     * 
     * @param licenses 需要删除的消防车信息管理主键集合
     * @return 结果
     */
    public int deleteTruckInformByLicenses(String[] licenses);

    /**
     * 删除消防车信息管理信息
     * 
     * @param license 消防车信息管理主键
     * @return 结果
     */
    public int deleteTruckInformByLicense(String license);
}
