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
import com.ruoyi.knowledge.domain.Special;
import com.ruoyi.knowledge.service.ISpecialService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专项知识库Controller
 * 
 * @author Mathripper
 * @date 2021-11-06
 */
@RestController
@RequestMapping("/knowledge/special")
public class SpecialController extends BaseController
{
    @Autowired
    private ISpecialService specialService;

    /**
     * 查询专项知识库列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:special:list')")
    @GetMapping("/list")
    public TableDataInfo list(Special special)
    {
        startPage();
        List<Special> list = specialService.selectSpecialList(special);
        return getDataTable(list);
    }

    /**
     * 导出专项知识库列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:special:export')")
    @Log(title = "专项知识库", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Special special)
    {
        List<Special> list = specialService.selectSpecialList(special);
        ExcelUtil<Special> util = new ExcelUtil<Special>(Special.class);
        return util.exportExcel(list, "专项知识库数据");
    }

    /**
     * 获取专项知识库详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:special:query')")
    @GetMapping(value = "/{informid}")
    public AjaxResult getInfo(@PathVariable("informid") Integer informid)
    {
        return AjaxResult.success(specialService.selectSpecialByInformid(informid));
    }

    /**
     * 新增专项知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:special:add')")
    @Log(title = "专项知识库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Special special)
    {
        return toAjax(specialService.insertSpecial(special));
    }

    /**
     * 修改专项知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:special:edit')")
    @Log(title = "专项知识库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Special special)
    {
        return toAjax(specialService.updateSpecial(special));
    }

    /**
     * 删除专项知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:special:remove')")
    @Log(title = "专项知识库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{informids}")
    public AjaxResult remove(@PathVariable Integer[] informids)
    {
        return toAjax(specialService.deleteSpecialByInformids(informids));
    }
}
