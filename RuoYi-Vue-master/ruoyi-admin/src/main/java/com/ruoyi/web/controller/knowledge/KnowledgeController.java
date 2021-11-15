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
public class KnowledgeController extends BaseController
{
    @Autowired
    private IKnowledgeService knowledgeService;

    /**
     * 查询通用知识库列表
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
     * 导出通用知识库列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:export')")
    @Log(title = "通用知识库", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Knowledge knowledge)
    {
        List<Knowledge> list = knowledgeService.selectKnowledgeList(knowledge);
        ExcelUtil<Knowledge> util = new ExcelUtil<Knowledge>(Knowledge.class);
        return util.exportExcel(list, "通用知识库数据");
    }

    /**
     * 获取通用知识库详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:query')")
    @GetMapping(value = "/{informid}")
    public AjaxResult getInfo(@PathVariable("informid") Long informid)
    {
        return AjaxResult.success(knowledgeService.selectKnowledgeByInformid(informid));
    }

    /**
     * 新增通用知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:add')")
    @Log(title = "通用知识库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Knowledge knowledge)
    {
        return toAjax(knowledgeService.insertKnowledge(knowledge));
    }

    /**
     * 修改通用知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:edit')")
    @Log(title = "通用知识库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Knowledge knowledge)
    {
        return toAjax(knowledgeService.updateKnowledge(knowledge));
    }

    /**
     * 删除通用知识库
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:remove')")
    @Log(title = "通用知识库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{informids}")
    public AjaxResult remove(@PathVariable Long[] informids)
    {
        return toAjax(knowledgeService.deleteKnowledgeByInformids(informids));
    }


    private static List<String> toRepeat(List<String> list) {
        //定义一个Set集合
        Set<String> set = new HashSet<String>();
        //新定义一个List集合
        List<String> newList = new ArrayList<String>();
        //迭代遍历集合，利用Set集合的特性（不含有重复对象），即可达到去重的目的
        for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
            String element = (String) iter.next();
            if (set.add(element)) {
                newList.add(element);
            }
        }
        return newList;
    }


    @GetMapping("/pushOneUser")
    public String pushOneUser() {
//        Date currentTime = new Date();
        String str="2001-01-01";
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd ");
        Date date= null;
        try {
            date=format1.parse(str);}
        catch (ParseException e) {
            e.printStackTrace();
        }
        return applist("1",date);
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
    public String applist(String openid, Date sendtime) {
//    public TableDataInfo applist(String openid, Date sendtime) {

//        查询手机号
        String location = null;
        String disastertype = null;
        String disastertype1 = null;
        Date cautiontime = null;
        String metw = null;
        Boolean status = null;
        String tele;

        Kappinfo info = new Kappinfo();
        Kappinfo info1 = new Kappinfo();

        List<Knowledge> listK = new ArrayList<Knowledge>();//提示信息列表
        List<String> text1 = new ArrayList<>();//提示信息列表
        List<String> text = new ArrayList<>();//提示信息列表
        List<Kappinfo> result = new ArrayList<Kappinfo>();
        List<History> caution = new ArrayList<History>();
        List<Record> in = new ArrayList<Record>();
//        根据手机号查询informid
        List<History> listInform = new ArrayList<>();
        List<History> listInform1 = new ArrayList<>();
        List<String> cautionID=new ArrayList<>();
        String op=null;

        tele = knowledgeService.selecttelebyOpenID(openid);
        caution = knowledgeService.selectCautionbytele(tele);
        for (History a : caution) {
            op=a.getCautionid();
            cautionID.add(op);
        }
        cautionID=toRepeat(cautionID);
        System.out.print(cautionID);
        for (String h : cautionID) {
//            info = new Kappinfo();
//            根据cautionid查询任务状态
            status = knowledgeService.selectStatusbyCaution(h);
            text1 = new ArrayList<>();//提示信息列表
//           如果已经完成，根据cautionid和tele查询即可
            if (status) {
//                查询信息编号
                listInform = knowledgeService.selectInformIDbycau(tele, h);
//              查询每个informid对应的信息
                for (History r : listInform) {
                    long b = Long.valueOf(r.getInformid()).longValue();
//                  根据informid查询提示信息
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
//                根据电话和时间查询记录表中的位置、类型、时间
                in = knowledgeService.selectRecord2(h);
                for (Record i : in) {
                    location = i.getLocation();
                    disastertype = i.getCautionid();
                    cautiontime = i.getCautiontime();
                }
//              查询类型名称
                disastertype1 = knowledgeService.selectDisaster(disastertype);
                info.addInfo(location, text1, disastertype1, cautiontime);
            }
            if(!status) {
                listInform = knowledgeService.selectInformIDbytele(tele, sendtime,h);
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
                    listInform1 = knowledgeService.selectInformIDbytele1(tele, d);
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
                result.add(info1);
            }
        }
        WxMssVo wxMssVo = new WxMssVo();
        wxMssVo.setTouser(openid);//用户的openid（要发送给那个用户，通常这里应该动态传进来的）
        wxMssVo.setTemplate_id("CFeSWarQLMPyPjwmiy6AV4eB-IZcipu48V8bFLkBzTU");//订阅消息模板id
        wxMssVo.setPage("pages/index/index");
        result.add(info);
        wxMssVo.setData(result);
//        return getDataTable(result);
        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + getAccessToken();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(url, wxMssVo, String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/getAccessToken")
    public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("APPID", "wx7c54942dfc87f4d8");  //
        params.put("APPSECRET", "5873a729c365b65ab42bb5fc82d2ed49");  //
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={APPID}&secret={APPSECRET}", String.class, params);
        String body = responseEntity.getBody();
        JSONObject object = JSON.parseObject(body);
        String Access_Token = object.getString("access_token");
        String expires_in = object.getString("expires_in");
        System.out.println("有效时长expires_in：" + expires_in);
        return Access_Token;
    }
}