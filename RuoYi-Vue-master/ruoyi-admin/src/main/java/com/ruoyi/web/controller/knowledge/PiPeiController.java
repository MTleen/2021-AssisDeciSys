package com.ruoyi.web.controller.knowledge;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.domain.PiPei;
import com.ruoyi.knowledge.service.IPiPeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//public class PiPeiController {
//}



/**
 * 出警记录表Controller
 *
 * @author ruoyi
 * @date 2021-10-15
 */
@RestController
@RequestMapping("/index")
public class PiPeiController extends BaseController
{
    @Autowired
    private IPiPeiService pipeiService;

    /**
     * 查询出警记录表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:pipei:list')")
    @GetMapping("/list")
    public TableDataInfo list(PiPei pipei )
    {
        startPage();
        List<PiPei> list = pipeiService.selectPiPeiList(pipei);
        return getDataTable(list);
    }

    /**
     * 新增出警记录表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:pipei:add')")
    @Log(title = "出警记录表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PiPei pipei)
    {
        return toAjax(pipeiService.insertPiPei(pipei));
    }

    /**
     * 修改出警记录表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:pipei:edit')")
    @Log(title = "出警记录表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PiPei pipei)
    {
        return toAjax(pipeiService.updatePiPei(pipei));
    }


}
