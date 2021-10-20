package com.ruoyi.information.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.SysDeptMapper;
import com.ruoyi.information.domain.SysDept;
import com.ruoyi.information.service.ISysDeptService;

/**
 * 队站信息管理Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService 
{
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询队站信息管理
     * 
     * @param deptId 队站信息管理主键
     * @return 队站信息管理
     */
    @Override
    public SysDept selectSysDeptByDeptId(Long deptId)
    {
        return sysDeptMapper.selectSysDeptByDeptId(deptId);
    }

    /**
     * 查询队站信息管理列表
     * 
     * @param sysDept 队站信息管理
     * @return 队站信息管理
     */
    @Override
    public List<SysDept> selectSysDeptList(SysDept sysDept)
    {
        return sysDeptMapper.selectSysDeptList(sysDept);
    }

    /**
     * 新增队站信息管理
     * 
     * @param sysDept 队站信息管理
     * @return 结果
     */
    @Override
    public int insertSysDept(SysDept sysDept)
    {
        sysDept.setCreateTime(DateUtils.getNowDate());
        return sysDeptMapper.insertSysDept(sysDept);
    }

    /**
     * 修改队站信息管理
     * 
     * @param sysDept 队站信息管理
     * @return 结果
     */
    @Override
    public int updateSysDept(SysDept sysDept)
    {
        sysDept.setUpdateTime(DateUtils.getNowDate());
        return sysDeptMapper.updateSysDept(sysDept);
    }

    /**
     * 批量删除队站信息管理
     * 
     * @param deptIds 需要删除的队站信息管理主键
     * @return 结果
     */
    @Override
    public int deleteSysDeptByDeptIds(Long[] deptIds)
    {
        return sysDeptMapper.deleteSysDeptByDeptIds(deptIds);
    }

    /**
     * 删除队站信息管理信息
     * 
     * @param deptId 队站信息管理主键
     * @return 结果
     */
    @Override
    public int deleteSysDeptByDeptId(Long deptId)
    {
        return sysDeptMapper.deleteSysDeptByDeptId(deptId);
    }
}
