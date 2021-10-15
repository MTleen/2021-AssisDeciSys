package com.ruoyi.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.AdminMapper;
import com.ruoyi.information.domain.Admin;
import com.ruoyi.information.service.IAdminService;

/**
 * 权限管理Service业务层处理
 * 
 * @author wuliangrui
 * @date 2021-10-15
 */
@Service
public class AdminServiceImpl implements IAdminService 
{
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 查询权限管理
     * 
     * @param adminid 权限管理主键
     * @return 权限管理
     */
    @Override
    public Admin selectAdminByAdminid(Long adminid)
    {
        return adminMapper.selectAdminByAdminid(adminid);
    }

    /**
     * 查询权限管理列表
     * 
     * @param admin 权限管理
     * @return 权限管理
     */
    @Override
    public List<Admin> selectAdminList(Admin admin)
    {
        return adminMapper.selectAdminList(admin);
    }

    /**
     * 新增权限管理
     * 
     * @param admin 权限管理
     * @return 结果
     */
    @Override
    public int insertAdmin(Admin admin)
    {
        return adminMapper.insertAdmin(admin);
    }

    /**
     * 修改权限管理
     * 
     * @param admin 权限管理
     * @return 结果
     */
    @Override
    public int updateAdmin(Admin admin)
    {
        return adminMapper.updateAdmin(admin);
    }

    /**
     * 批量删除权限管理
     * 
     * @param adminids 需要删除的权限管理主键
     * @return 结果
     */
    @Override
    public int deleteAdminByAdminids(Long[] adminids)
    {
        return adminMapper.deleteAdminByAdminids(adminids);
    }

    /**
     * 删除权限管理信息
     * 
     * @param adminid 权限管理主键
     * @return 结果
     */
    @Override
    public int deleteAdminByAdminid(Long adminid)
    {
        return adminMapper.deleteAdminByAdminid(adminid);
    }
}
