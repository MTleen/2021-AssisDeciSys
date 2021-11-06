package com.ruoyi.web.controller.knowledge;

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
import com.ruoyi.knowledge.domain.Security;
import com.ruoyi.knowledge.service.ISecurityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 安全知识库Controller
 * 
 * @author Mathripper
 * @date 2021-11-06
 */
@RestController
@RequestMapping("/knowledge/security")
public class SecurityController extends BaseController
{
    @Autowired
    private ISecurityService securityService;

    /**
     * 查询安全知识库列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:security:list')")
    @GetMapping("/list")
    public TableDataInfo list(Security security)
    {
        startPage();
        List<Security> list = securityService.selectSecurityList(security);
        return getDataTable(list);
    }

    /**
     * 导出安全知识库列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:security:export')")
    @Log(title = "安全知识库", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Security security)
    {
        List<Security> list = securityService.selectSecurityList(security);
        ExcelUtil<Security> util = new ExcelUtil<Security>(Security.class);
        return util.exportExcel(list, "安全知识库数据");
    }

    /**
     * 获取安全知识库详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:security:query')")
    @GetMapping(value = "/{informid}")
    public AjaxResult getInfo(@PathVariable("informid") Integer informid)
    {
        return AjaxResult.success(securityService.selectSecurityByInformid(informid));
    }

    /**
     * 新增安全知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:security:add')")
    @Log(title = "安全知识库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Security security)
    {
        return toAjax(securityService.insertSecurity(security));
    }

    /**
     * 修改安全知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:security:edit')")
    @Log(title = "安全知识库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Security security)
    {
        return toAjax(securityService.updateSecurity(security));
    }

    /**
     * 删除安全知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:security:remove')")
    @Log(title = "安全知识库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{informids}")
    public AjaxResult remove(@PathVariable Integer[] informids)
    {
        return toAjax(securityService.deleteSecurityByInformids(informids));
    }
}
