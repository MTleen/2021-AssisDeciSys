package com.ruoyi.web.controller.knowledge;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.knowledge.domain.*;
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
import com.ruoyi.knowledge.service.IKnowledgeService;
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
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
    @GetMapping("/applist")
    public TableDataInfo applist(String openid, Date sendtime) {

//        查询手机号
        String location = null;
        String disastertype = null;
        String disastertype1 = null;
        Date cautiontime = null;
        String metw = null;
        Boolean status = null;
        String tele;
        Integer library;

        Kappinfo info = new Kappinfo();
        Kappinfo info1 = new Kappinfo();

        List<Knowledge> listK = new ArrayList<Knowledge>();//提示信息列表
        List<Security> listS = new ArrayList<Security>();//提示信息列表
        List<String> text1 = new ArrayList<>();//提示信息列表
        List<String> text = new ArrayList<>();//提示信息列表
        List<Kappinfo> result = new ArrayList<Kappinfo>();
        List<History> caution = new ArrayList<History>();
        List<Record> in = new ArrayList<Record>();
//        根据手机号查询informid
        List<History> listInform = new ArrayList<>();
        List<History> listInform1 = new ArrayList<>();
        List<String> cautionID = new ArrayList<>();
        List<History> library1 = new ArrayList<>();
        List<Integer> libraryID = new ArrayList<>();
        String op = null;
        Integer ol = null;


        tele = knowledgeService.selecttelebyOpenID(openid);
        caution = knowledgeService.selectCautionbytele(tele);
        for (History a : caution) {
            op = a.getCautionid();
            cautionID.add(op);
        }
        cautionID = toRepeat(cautionID);
        System.out.print(cautionID);
        for (String h : cautionID) {
            //info = new Kappinfo();
            //根据cautionid查询任务状态
            status = knowledgeService.selectStatusbyCaution(h);
            library1 = knowledgeService.selectLibrarybyCaution(h, tele, sendtime);
            System.out.print("--------");
            System.out.print(library1);
            System.out.print("--------");
            for (History l : library1) {
                ol = l.getLibrarytype();
                libraryID.add(ol);
            }
            System.out.print("--------");
            System.out.print(libraryID);
            System.out.print("--------");
            libraryID = toRepeat1(libraryID);
            text1 = new ArrayList<>();//提示信息列表
//           如果已经完成，根据cautionid和tele查询即可
            if (status) {
                for (Integer lib : libraryID) {
                    if (lib != 3) {
                        //查询信息编号
                        listInform = knowledgeService.selectInformIDbycau(tele, h, sendtime, lib);
                        //查询每个informid对应的信息
                        for (History r : listInform) {
                            long b = Long.valueOf(r.getInformid()).longValue();
                            //根据informid查询提示信息
                            listK = knowledgeService.selectKnow1(b);
                            for (Knowledge k : listK) {
                                metw = k.getInform();
                            }
                            text1.add(metw);
                        }
                        System.out.print("\n~~~~~~~~\n");
                        System.out.print(text1);
                        System.out.print("\n~~~~~~~~\n");
                        //根据手机号和发送时间查询记录表,得到报警编号
                        //根据电话和时间查询记录表中的位置、类型、时间
                    }
                    if (lib == 3) {
                        //查询信息编号
                        listInform = knowledgeService.selectInformIDbycau(tele, h, sendtime, lib);
                        //查询每个informid对应的信息
                        for (History r : listInform) {
                            long b = Long.valueOf(r.getInformid()).longValue();
                            //根据informid查询提示信息
                            listS = knowledgeService.selectKnow2(b);
                            for (Security k : listS) {
                                metw = k.getInform();
                            }
                            text1.add(metw);
                        }
                        System.out.print("\n~~~~~~~~\n");
                        System.out.print(text1);
                        System.out.print("\n~~~~~~~~\n");
                        //根据手机号和发送时间查询记录表,得到报警编号
                        //根据电话和时间查询记录表中的位置、类型、时间
//                        in = knowledgeService.selectRecord2(h);
//                        for (Record i : in) {
//                            location = i.getLocation();
//                            disastertype = i.getCautionid();
//                            cautiontime = i.getCautiontime();
//                        }
//                        //查询类型名称
//                        disastertype1 = knowledgeService.selectDisaster(disastertype);
//                        info.addInfo(location, text1, disastertype1, cautiontime);
                    }
                }
                in = knowledgeService.selectRecord2(h);
                for (Record i : in) {
                    location = i.getLocation();
                    disastertype = i.getCautionid();
                    cautiontime = i.getCautiontime();
                }
                //查询类型名称
                disastertype1 = knowledgeService.selectDisaster(disastertype);
                info.addInfo(location, text1, disastertype1, cautiontime);
            }

//未完成
            if (!status) {
                for (Integer lib : libraryID) {
                    if (lib != 3) {
                        listInform = knowledgeService.selectInformIDbytele(tele, h, sendtime, lib);
                        //              根据编号查信息
                        List<Date> date = new ArrayList<>();
                        for (History r : listInform) {
                            date.add(r.getSendtime());
                        }
                        HashSet hs1 = new HashSet();
                        hs1.addAll(date);
                        date.clear();
                        date.addAll(hs1);
                        Collections.sort(date, Collections.reverseOrder());
                        System.out.print(date);
                        //        以发送时间为分类
                        for (Date d : date) {
                            //          清除text之前存储的内容
                            text = new ArrayList<>();//提示信息列表
                            //           以电话和时间查询informid
                            listInform1 = knowledgeService.selectInformIDbytele1(tele, h, d, lib);
                            //            查询每个informid对应的信息
                            for (History r : listInform1) {
                                long b = Long.valueOf(r.getInformid()).longValue();
                                //            根据informid查询提示信息
                                listK = knowledgeService.selectKnow1(b);
                                for (Knowledge k : listK) {
                                    metw = k.getInform();
                                }
                                text.add(metw);
                                System.out.print(text);
                            }
                            //            根据手机号和发送时间查询记录表,得到报警编号
                            //                根据电话和时间查询记录表中的位置、类型、时间
                            in = knowledgeService.selectRecord2(h);
                            System.out.print(in);
                            System.out.print("-------\n");
                            for (Record i : in) {
                                location = i.getLocation();
                                disastertype = i.getCautionid();
                                cautiontime = i.getCautiontime();
                            }
                            //                查询类型名称
                            disastertype1 = knowledgeService.selectDisaster(disastertype);
                            info1.addInfo(location, text, disastertype1, cautiontime);
                            System.out.print("\n~~~~~~~~\n");
                            System.out.print(info1);
                            System.out.print("\n~~~~~~~~\n");
                        }
//                        result.add(info1);
                    }
                    if (lib == 3) {
                        listInform = knowledgeService.selectInformIDbytele(tele, h, sendtime, lib);
                        //              根据编号查信息
                        List<Date> date = new ArrayList<>();
                        for (History r : listInform) {
                            date.add(r.getSendtime());
                        }
                        HashSet hs1 = new HashSet();
                        hs1.addAll(date);
                        date.clear();
                        date.addAll(hs1);
                        Collections.sort(date, Collections.reverseOrder());
                        System.out.print(date);
                        //        以发送时间为分类
                        for (Date d : date) {
                            //          清除text之前存储的内容
                            text = new ArrayList<>();//提示信息列表
                            //           以电话和时间查询informid
                            listInform1 = knowledgeService.selectInformIDbytele1(tele, h, d, lib);
                            //            查询每个informid对应的信息
                            for (History r : listInform1) {
                                long b = Long.valueOf(r.getInformid()).longValue();
                                //            根据informid查询提示信息
                                listS = knowledgeService.selectKnow2(b);
                                for (Security k : listS) {
                                    metw = k.getInform();
                                }
                                text.add(metw);
                                System.out.print(text);
                            }
                            //            根据手机号和发送时间查询记录表,得到报警编号
                            //                根据电话和时间查询记录表中的位置、类型、时间
                            in = knowledgeService.selectRecord2(h);
                            System.out.print(in);
                            System.out.print("-------\n");
                            for (Record i : in) {
                                location = i.getLocation();
                                disastertype = i.getCautionid();
                                cautiontime = i.getCautiontime();
                            }
                            //                查询类型名称
                            disastertype1 = knowledgeService.selectDisaster(disastertype);
                            info1.addInfo(location, text, disastertype1, cautiontime);
                            System.out.print("\n~~~~~~~~\n");
                            System.out.print(info1);
                            System.out.print("\n~~~~~~~~\n");
                        }

                    }

                }
            }


        }
        result.add(info1);
        result.add(info);
        return getDataTable(result);

    }
}
