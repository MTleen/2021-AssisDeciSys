package com.ruoyi.information.service;

import java.util.List;
import com.ruoyi.information.domain.SysDept;

/**
 * 队站信息管理Service接口
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
public interface ISysDeptService 
{
    /**
     * 查询队站信息管理
     * 
     * @param deptId 队站信息管理主键
     * @return 队站信息管理
     */
    public SysDept selectSysDeptByDeptId(Long deptId);

    /**
     * 查询队站信息管理列表
     * 
     * @param sysDept 队站信息管理
     * @return 队站信息管理集合
     */
    public List<SysDept> selectSysDeptList(SysDept sysDept);

    /**
     * 新增队站信息管理
     * 
     * @param sysDept 队站信息管理
     * @return 结果
     */
    public int insertSysDept(SysDept sysDept);

    /**
     * 修改队站信息管理
     * 
     * @param sysDept 队站信息管理
     * @return 结果
     */
    public int updateSysDept(SysDept sysDept);

    /**
     * 批量删除队站信息管理
     * 
     * @param deptIds 需要删除的队站信息管理主键集合
     * @return 结果
     */
    public int deleteSysDeptByDeptIds(Long[] deptIds);

    /**
     * 删除队站信息管理信息
     * 
     * @param deptId 队站信息管理主键
     * @return 结果
     */
    public int deleteSysDeptByDeptId(Long deptId);
}
