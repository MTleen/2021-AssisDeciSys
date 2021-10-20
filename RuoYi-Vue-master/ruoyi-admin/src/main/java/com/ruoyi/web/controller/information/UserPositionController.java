package com.ruoyi.information.controller;

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
import com.ruoyi.information.domain.UserPosition;
import com.ruoyi.information.service.IUserPositionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 岗位信息表管理Controller
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
@RestController
@RequestMapping("/information/userposition")
public class UserPositionController extends BaseController
{
    @Autowired
    private IUserPositionService userPositionService;

    /**
     * 查询岗位信息表管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:userposition:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserPosition userPosition)
    {
        startPage();
        List<UserPosition> list = userPositionService.selectUserPositionList(userPosition);
        return getDataTable(list);
    }

    /**
     * 导出岗位信息表管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:userposition:export')")
    @Log(title = "岗位信息表管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(UserPosition userPosition)
    {
        List<UserPosition> list = userPositionService.selectUserPositionList(userPosition);
        ExcelUtil<UserPosition> util = new ExcelUtil<UserPosition>(UserPosition.class);
        return util.exportExcel(list, "岗位信息表管理数据");
    }

    /**
     * 获取岗位信息表管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:userposition:query')")
    @GetMapping(value = "/{positionid}")
    public AjaxResult getInfo(@PathVariable("positionid") Long positionid)
    {
        return AjaxResult.success(userPositionService.selectUserPositionByPositionid(positionid));
    }

    /**
     * 新增岗位信息表管理
     */
    @PreAuthorize("@ss.hasPermi('information:userposition:add')")
    @Log(title = "岗位信息表管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserPosition userPosition)
    {
        return toAjax(userPositionService.insertUserPosition(userPosition));
    }

    /**
     * 修改岗位信息表管理
     */
    @PreAuthorize("@ss.hasPermi('information:userposition:edit')")
    @Log(title = "岗位信息表管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserPosition userPosition)
    {
        return toAjax(userPositionService.updateUserPosition(userPosition));
    }

    /**
     * 删除岗位信息表管理
     */
    @PreAuthorize("@ss.hasPermi('information:userposition:remove')")
    @Log(title = "岗位信息表管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{positionids}")
    public AjaxResult remove(@PathVariable Long[] positionids)
    {
        return toAjax(userPositionService.deleteUserPositionByPositionids(positionids));
    }
}
