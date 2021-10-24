package com.ruoyi.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.TruckInformMapper;
import com.ruoyi.information.domain.TruckInform;
import com.ruoyi.information.service.ITruckInformService;

/**
 * 消防车信息管理Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
@Service
public class TruckInformServiceImpl implements ITruckInformService 
{
    @Autowired
    private TruckInformMapper truckInformMapper;

    /**
     * 查询消防车信息管理
     * 
     * @param license 消防车信息管理主键
     * @return 消防车信息管理
     */
    @Override
    public TruckInform selectTruckInformByLicense(String license)
    {
        return truckInformMapper.selectTruckInformByLicense(license);
    }

    /**
     * 查询消防车信息管理列表
     * 
     * @param truckInform 消防车信息管理
     * @return 消防车信息管理
     */
    @Override
    public List<TruckInform> selectTruckInformList(TruckInform truckInform)
    {
        return truckInformMapper.selectTruckInformList(truckInform);
    }

    /**
     * 新增消防车信息管理
     * 
     * @param truckInform 消防车信息管理
     * @return 结果
     */
    @Override
    public int insertTruckInform(TruckInform truckInform)
    {
        return truckInformMapper.insertTruckInform(truckInform);
    }

    /**
     * 修改消防车信息管理
     * 
     * @param truckInform 消防车信息管理
     * @return 结果
     */
    @Override
    public int updateTruckInform(TruckInform truckInform)
    {
        return truckInformMapper.updateTruckInform(truckInform);
    }

    /**
     * 批量删除消防车信息管理
     * 
     * @param licenses 需要删除的消防车信息管理主键
     * @return 结果
     */
    @Override
    public int deleteTruckInformByLicenses(String[] licenses)
    {
        return truckInformMapper.deleteTruckInformByLicenses(licenses);
    }

    /**
     * 删除消防车信息管理信息
     * 
     * @param license 消防车信息管理主键
     * @return 结果
     */
    @Override
    public int deleteTruckInformByLicense(String license)
    {
        return truckInformMapper.deleteTruckInformByLicense(license);
    }
}
