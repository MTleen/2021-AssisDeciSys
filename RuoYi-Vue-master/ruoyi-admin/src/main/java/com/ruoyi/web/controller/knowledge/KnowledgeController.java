package com.ruoyi.web.controller.knowledge;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
import com.ruoyi.knowledge.domain.Knowledge;
import com.ruoyi.knowledge.domain.Kwords;
import com.ruoyi.knowledge.domain.Kinfo;
import com.ruoyi.knowledge.domain.Rule;
import com.ruoyi.knowledge.service.IKnowledgeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.*;

/**
 * 提示信息表Controller
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@Api("提示信息表管理")
@RestController
@RequestMapping("/knowledge/knowledge")
public class KnowledgeController extends BaseController
{
    @Autowired
    private IKnowledgeService knowledgeService;

    /**
     * 查询提示信息表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
    @GetMapping("/list")
    public TableDataInfo list(Knowledge knowledge)
    {
        startPage();
        List<Knowledge> list = knowledgeService.selectKnowledgeList(knowledge);
        return getDataTable(list);
    }

    /**
     * 导出提示信息表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:export')")
    @Log(title = "提示信息表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Knowledge knowledge)
    {
        List<Knowledge> list = knowledgeService.selectKnowledgeList(knowledge);
        ExcelUtil<Knowledge> util = new ExcelUtil<Knowledge>(Knowledge.class);
        return util.exportExcel(list, "提示信息表数据");
    }

    /**
     * 匹配提示信息并按规则分组
     */
    @ApiOperation("匹配提示信息并按规则分组")
    @ApiImplicitParams({
        @ApiImplicitParam(name="disastertype",value="险情类型",required = true,dataType="Long"),
        @ApiImplicitParam(name="disposeobj",value="处置对象",dataType="Long"),
        @ApiImplicitParam(name="detailtype",value="详细类型",dataType="Long"),
        @ApiImplicitParam(name="label4",value="四级标签",dataType="Long"),
        @ApiImplicitParam(name="keyword",value="关键字",dataType="String")
    })
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
    @GetMapping("/match")
    public TableDataInfo match(Kwords kwords)
    {
        startPage();
        List<Knowledge> knowledges = knowledgeService.matchKnowledgeList(kwords);
        List<Rule> rules = knowledgeService.selectRuleList();
        List<Kinfo> result= new ArrayList<Kinfo>();
        Map<String,List<String>> rulemap = new HashMap<String,List<String>>(); 
        //规则获取与处理
        for(Rule x:rules){
            if(!rulemap.containsKey(x.getPositionid())){
                rulemap.put(x.getPositionid(),new ArrayList<String>());
            }
            rulemap.get(x.getPositionid()).add(x.getInformtype());
        }
        //提示信息按岗位整合
        for(String y:rulemap.keySet()){
            result.add(new Kinfo(y));
            for(Knowledge k:knowledges){
                if(rulemap.get(y).contains(k.getInformtypeid())){
                    result.get(result.size()-1).addInfo(Long.toString(k.getInformid()),k.getInform(),k.getInformtypeid());
                }
            }
        }
        return getDataTable(result);
    }

    /**
     * 获取提示信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:query')")
    @GetMapping(value = "/{informid}")
    public AjaxResult getInfo(@PathVariable("informid") Long informid)
    {
        return AjaxResult.success(knowledgeService.selectKnowledgeByInformid(informid));
    }

    /**
     * 新增提示信息表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:add')")
    @Log(title = "提示信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Knowledge knowledge)
    {
        return toAjax(knowledgeService.insertKnowledge(knowledge));
    }

    /**
     * 修改提示信息表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:edit')")
    @Log(title = "提示信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Knowledge knowledge)
    {
        return toAjax(knowledgeService.updateKnowledge(knowledge));
    }

    /**
     * 删除提示信息表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:remove')")
    @Log(title = "提示信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{informids}")
    public AjaxResult remove(@PathVariable Long[] informids)
    {
        return toAjax(knowledgeService.deleteKnowledgeByInformids(informids));
    }
}
