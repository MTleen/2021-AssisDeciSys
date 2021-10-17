package com.ruoyi.web.controller.information;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.information.domain.Admin;
import com.ruoyi.information.service.IAdminService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 权限管理Controller
 * 
 * @author wuliangrui
 * @date 2021-10-15
 */
@RestController
@RequestMapping("/information/admin")
public class AdminController extends BaseController
{
    @Autowired
    private IAdminService adminService;

    /**
     * 查询权限管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:admin:list')")
    @GetMapping("/list")
    public TableDataInfo list(Admin admin)
    {
        startPage();
        List<Admin> list = adminService.selectAdminList(admin);
        return getDataTable(list);
    }

    /**
     * 导出权限管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:admin:export')")
    @Log(title = "权限管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Admin admin)
    {
        List<Admin> list = adminService.selectAdminList(admin);
        ExcelUtil<Admin> util = new ExcelUtil<Admin>(Admin.class);
        return util.exportExcel(list, "权限管理数据");
    }

    /**
     * 获取权限管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:admin:query')")
    @GetMapping(value = "/{adminid}")
    public AjaxResult getInfo(@PathVariable("adminid") Long adminid)
    {
        return AjaxResult.success(adminService.selectAdminByAdminid(adminid));
    }

    /**
     * 新增权限管理
     */
    @PreAuthorize("@ss.hasPermi('information:admin:add')")
    @Log(title = "权限管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Admin admin)
    {
        return toAjax(adminService.insertAdmin(admin));
    }

    /**
     * 修改权限管理
     */
    @PreAuthorize("@ss.hasPermi('information:admin:edit')")
    @Log(title = "权限管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Admin admin)
    {
        return toAjax(adminService.updateAdmin(admin));
    }

    /**
     * 删除权限管理
     */
    @PreAuthorize("@ss.hasPermi('information:admin:remove')")
    @Log(title = "权限管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{adminids}")
    public AjaxResult remove(@PathVariable Long[] adminids)
    {
        return toAjax(adminService.deleteAdminByAdminids(adminids));
    }
}
