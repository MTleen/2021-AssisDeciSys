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
import com.ruoyi.knowledge.domain.Rule;
import com.ruoyi.knowledge.service.IRuleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 规则表Controller
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@RestController
@RequestMapping("/knowledge/rule")
public class RuleController extends BaseController
{
    @Autowired
    private IRuleService ruleService;

    /**
     * 查询规则表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:rule:list')")
    @GetMapping("/list")
    public TableDataInfo list(Rule rule)
    {
        startPage();
        List<Rule> list = ruleService.selectRuleList(rule);
        return getDataTable(list);
    }

    /**
     * 导出规则表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:rule:export')")
    @Log(title = "规则表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Rule rule)
    {
        List<Rule> list = ruleService.selectRuleList(rule);
        ExcelUtil<Rule> util = new ExcelUtil<Rule>(Rule.class);
        return util.exportExcel(list, "规则表数据");
    }

    /**
     * 获取规则表详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:rule:query')")
    @GetMapping(value = "/{ruleid}")
    public AjaxResult getInfo(@PathVariable("ruleid") Long ruleid)
    {
        return AjaxResult.success(ruleService.selectRuleByRuleid(ruleid));
    }

    /**
     * 新增规则表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:rule:add')")
    @Log(title = "规则表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Rule rule)
    {
        return toAjax(ruleService.insertRule(rule));
    }

    /**
     * 修改规则表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:rule:edit')")
    @Log(title = "规则表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Rule rule)
    {
        return toAjax(ruleService.updateRule(rule));
    }

    /**
     * 删除规则表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:rule:remove')")
    @Log(title = "规则表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ruleids}")
    public AjaxResult remove(@PathVariable Long[] ruleids)
    {
        return toAjax(ruleService.deleteRuleByRuleids(ruleids));
    }
}
