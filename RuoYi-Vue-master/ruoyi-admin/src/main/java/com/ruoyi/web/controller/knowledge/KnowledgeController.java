package com.ruoyi.web.controller.knowledge;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.knowledge.domain.*;
import com.ruoyi.knowledge.domain.Record;

import com.ruoyi.knowledge.mapper.KnowledgeMapper;
import com.ruoyi.knowledge.service.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * 通用知识库Controller
 *
 * @author Mathripper
 * @date 2021-11-06
 */
@RestController
@RequestMapping("/knowledge/knowledge")
public class KnowledgeController extends BaseController {
    @Autowired
    private IKnowledgeService knowledgeService;
    @Autowired
    private ISpecialService specialService;
    @Autowired
    private ISecurityService securityService;
    @Autowired
    private IRecordService recordService;
    @Autowired
    private IDisasterTypeService disasterTypeService;

    /**
     * 查询通用知识库列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
    @GetMapping("/list")
    public TableDataInfo list(Knowledge knowledge) {
        startPage();
        List<Knowledge> list = knowledgeService.selectKnowledgeList(knowledge);
        return getDataTable(list);
    }

    /**
     * 导出通用知识库列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:export')")
    @Log(title = "通用知识库", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Knowledge knowledge) {
        List<Knowledge> list = knowledgeService.selectKnowledgeList(knowledge);
        ExcelUtil<Knowledge> util = new ExcelUtil<Knowledge>(Knowledge.class);
        return util.exportExcel(list, "通用知识库数据");
    }

    /**
     * 获取通用知识库详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:query')")
    @GetMapping(value = "/{informid}")
    public AjaxResult getInfo(@PathVariable("informid") Long informid) {
        return AjaxResult.success(knowledgeService.selectKnowledgeByInformid(informid));
    }

    /**
     * 新增通用知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:add')")
    @Log(title = "通用知识库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Knowledge knowledge) {
        return toAjax(knowledgeService.insertKnowledge(knowledge));
    }

    /**
     * 修改通用知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:edit')")
    @Log(title = "通用知识库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Knowledge knowledge) {
        return toAjax(knowledgeService.updateKnowledge(knowledge));
    }

    /**
     * 删除通用知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:remove')")
    @Log(title = "通用知识库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{informids}")
    public AjaxResult remove(@PathVariable Long[] informids) {
        return toAjax(knowledgeService.deleteKnowledgeByInformids(informids));
    }


    private static List<String> toRepeat(List<String> list) {
        //定义一个Set集合
        Set<String> set = new HashSet<String>();
        //新定义一个List集合
        List<String> newList = new ArrayList<String>();
        //迭代遍历集合，利用Set集合的特性（不含有重复对象），即可达到去重的目的
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String element = (String) iter.next();
            if (set.add(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    private static List<Integer> toRepeat1(List<Integer> list) {
        //定义一个Set集合
        Set<Integer> set = new HashSet<Integer>();
        //新定义一个List集合
        List<Integer> newList = new ArrayList<Integer>();
        //迭代遍历集合，利用Set集合的特性（不含有重复对象），即可达到去重的目的
        for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
            Integer element = (Integer) iter.next();
            if (set.add(element)) {
                newList.add(element);
            }
        }
        return newList;
    }


    /**
     * App查询推送历史记录
     */
    @ApiOperation("App查询推送历史记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openid", value = "OpenId", dataType = "String"),
            @ApiImplicitParam(name = "sendtime", value = "截止时间", dataType = "Date")
    })
//    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
    @GetMapping("/applist")
    public TableDataInfo applist(String openid, Date sendtime) {

//        查询手机号
        String location = null;
        String disastertype = null;
        Date cautiontime = null;
        Boolean status = null;
        String tele;

        Kappinfo info = new Kappinfo();
        Kappinfo info1 = new Kappinfo();

        List<String> text1 = new ArrayList<>();//提示信息列表
        List<Kappinfo> result = new ArrayList<Kappinfo>();
        List<History> cautions = new ArrayList<History>();
        List<History> cautionInforms = new ArrayList<>();
        String cid = null;
        // 根据 openid 查询 tele
        tele = knowledgeService.selecttelebyOpenID(openid);
        // 根据 tele 查询所有匹配的 cautionid
        cautions = knowledgeService.selectCautionbytele(tele);
        // 遍历 cautionids
        for (History caution : cautions) {
            cid = caution.getCautionid();
            // 根据 cautionid 查找 record
            Record record = recordService.selectRecordByCautionid(cid);
            location = record.getLocation();
            disastertype = disasterTypeService.selectDisasterTypeByTypeid(record.getDistypeid()).getTypename();
            cautiontime = record.getCautiontime();
            //根据cautionid查询任务状态
            status = knowledgeService.selectStatusbyCaution(cid);
            // 根据 cautionid 查询所有相关 informid 及 librarytype
            cautionInforms = knowledgeService.selectInformByCaution(cid, tele, sendtime);

            text1 = new ArrayList<>();//提示信息列表
            for (History his : cautionInforms) {
                Integer libraryType = his.getLibrarytype();
                String informId = his.getInformid();
                switch (libraryType) {
                    case 1:
                        Knowledge kl = knowledgeService.selectKnowledgeByInformid(Long.valueOf(informId));
                        text1.add(kl.getInform());
                        break;
                    case 2:
                        Security se = securityService.selectSecurityByInformid(Integer.valueOf(informId));
                        text1.add(se.getInform());
                        break;
                    case 3:
                        Special sp = specialService.selectSpecialByInformid(Integer.valueOf(informId));
                        text1.add(sp.getInform());
                        break;
                    default:
                        break;
                }
            }
            if (status) {
                info.addInfo(location, text1, disastertype, cautiontime);
            } else {
                info1.addInfo(location, text1, disastertype, cautiontime);
            }
        }
        result.add(info1);
        result.add(info);
        return getDataTable(result);
    }
}
