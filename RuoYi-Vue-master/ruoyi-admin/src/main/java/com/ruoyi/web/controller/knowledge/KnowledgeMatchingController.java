package com.ruoyi.web.controller.knowledge;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Date;

import com.ruoyi.information.service.IUserInfoMatchingService;
import com.ruoyi.sendToWeChat.domain.TemplateData;
import com.ruoyi.web.controller.sendToWeChat.sendToWeChat_Com;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.controller.sendToWeChat.sendMessage;
import com.ruoyi.knowledge.domain.*;
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.service.*;
import com.ruoyi.information.domain.UserInfo;
import com.ruoyi.information.service.IUserInfoService;
import io.swagger.annotations.*;
import java.text.SimpleDateFormat;

/**
 * 信息推送Controller
 *
 * @author MP5Leader
 * @date 2021-11-09
 */
@Api("信息推送模块")
@RestController
@RequestMapping("/knowledge/match")
public class KnowledgeMatchingController extends BaseController {
    static class TestTemplate//信息推送的测试结果
    {
        String openid;
        Map<String, String> record;
        List<Kinfo> inform;

        public TestTemplate() {
            openid = new String();
            record = new HashMap<String, String>();
            inform = new ArrayList<Kinfo>();
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public Map<String, String> getRecord() {
            return record;
        }

        public void setRecord(Map<String, String> record) {
            this.record = record;
        }

        public List<Kinfo> getInform() {
            return inform;
        }

        public void setInform(List<Kinfo> inform) {
            this.inform = inform;
        }
    }

    @Autowired
    private IKnowledgeMatchingService knowledgeMatchingService;

    @Autowired
    private IKnowledgeService knowledgeService;

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private ISpecialService specialService;

    @Autowired
    private IRuleService ruleService;

    @Autowired
    private IHistoryService historyService;

    @Autowired
    private IForceInvolveService forceInvolveService;

    @Autowired
    private ITypeRelationService typeRelationService;

    @Autowired
    private IRecordService recordService;
    
    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IDisasterTypeService disasterTypeService;

    @Autowired
    private sendMessage sendMessage;

    /**
     * xy
     * 创建sendToWeChat_Com类型的对象，用对象调用该类中的方法
     */
    @Autowired
    private sendToWeChat_Com sendtowechat_com;
    /**
     * xy
     * 创建sendToWeChat_Com类型的对象，用对象调用该类中的方法
     */
    @Autowired
    private IUserInfoMatchingService userInfoMatchingService;

    /**
     * 随机生成推送列表
     *
     * @param listsize 待推送列表长度
     * @param num      推送数量
     * @return 推送信息index列表
     */
    public List<Integer> randomindex(Integer listsize, Long num) {
        if (listsize == 0 || listsize < num) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> count = new HashSet<Integer>();
        Random random = new Random();
        while (count.size() < num) {
            count.add(random.nextInt(listsize));
        }
        for (Integer i : count) {
            result.add(i);
        }
        return result;
    }
     @ApiOperation("test")
     @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
     @PostMapping("/test")
     public AjaxResult test(Long cid,Long l1,Long l2,Long l3,Boolean isGen,Long site) {
         Kwords query=new Kwords();
         query.setcautionID(cid);
         query.setaddress("address");
         query.setdate(new Date());
         query.setdistype(l1);
         query.setdisposeObj(l2);
         if(isGen){
             query.setgeneralType(l3);
         }else{
             query.setspecialType(l3);
         }
         query.setsiteID1(site);
         List<Long> diy=new ArrayList<Long>();
         diy.add(Long.valueOf("6"));
         diy.add(Long.valueOf("7"));
         query.setsiteID2(diy);
         return distribution(query);
     }
    /**
     * 提示信息推送接口
     */
    @ApiOperation("提示信息推送接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cautionID", value = "案件编号（为空则生成新案件记录）"),
            @ApiImplicitParam(name = "address", value = "地址"),
            @ApiImplicitParam(name = "date", value = "时间"),
            @ApiImplicitParam(name = "distype", value = "灾情类型（一级标签）", required = true),
            @ApiImplicitParam(name = "disposeObj", value = "处置对象（二级标签）", required = true),
            @ApiImplicitParam(name = "generalType", value = "通用类型（通用知识库，三级标签），专项类型和通用类型互斥，只能有一个不为空"),
            @ApiImplicitParam(name = "specialType", value = "专项类型（专项知识库，三级标签），专项类型和通用类型互斥，只能有一个不为空"),
            @ApiImplicitParam(name = "securityType", value = "安全类型（安全知识库）"),
            @ApiImplicitParam(name = "keyWords", value = "关键词"),
            @ApiImplicitParam(name = "siteID1", value = "主管对站ID", required = true),
            @ApiImplicitParam(name = "siteID2", value = "参战对站ID列表"),
    })
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
    @PostMapping("/distribution")
    public AjaxResult distribution(@RequestBody Kwords query) {
        List<Kinfo> krlist = new ArrayList<Kinfo>();//通用提示信息候选列表
        List<Kinfo> srlist = new ArrayList<Kinfo>();//专项提示信息候选列表
        List<Kinfo> sfrlist = new ArrayList<Kinfo>();//安全提示信息候选列表(非司通员)
        List<Kinfo> sfrlist2 = new ArrayList<Kinfo>();//安全提示信息候选列表(司通员)
        List<Kinfo> clist = new ArrayList<Kinfo>();//待发送的提示信息列表(非司通员)
        List<Kinfo> clist2 = new ArrayList<Kinfo>();//待发送的提示信息列表(司通员)
        Kinfo kinfo;
        Long ruleID;
        final Long safetynum = Long.valueOf("5");//推送的安全提示信息数量(司通员)
        final Long safetytypeid = Long.valueOf("29");//推送的安全提示信息详细类型(司通员)
        final Long safetypositionid = Long.valueOf("3");//司通员岗位ID
        /**
         * 分离query中案件记录部分
         */
        Record record = new Record();
        record.setCautiontime(query.getdate());
        record.setLocation(query.getaddress());
        record.setDistypeid(query.getdistype());
        record.setDillobject(query.getdisposeObj());
        if (query.getspecialType() != null) {
            record.setDetailtype(query.getspecialType());
        } else {
//            if(query.getgeneralType()!=null)
//            {
            record.setDetailtype(query.getgeneralType());
//            }
//            else
//            {
//                return AjaxResult.error("专项类型与通用类型不能都为空");
//            }
        }
        record.setStatus(1);
        record.setKeywords(query.getkeyWords());
        record.setSiteid(query.getsiteID1());
        String sites = new String();
        if (query.getsiteID2() != null) {
            for (Long x : query.getsiteID2()) {
                if (sites != null && !sites.isEmpty()) {
                    sites = sites + "," + x.toString();
                } else {
                    sites = x.toString();
                }
            }
        }
        record.setSiteid2(sites);
        if (query.getcautionID() == null)//保存至Record
        {
            knowledgeMatchingService.insertRecord(record);       //特殊方法写入Record表，返回生成的cautionID
            if (record.getCautionid() == null) {
                return AjaxResult.error("主键返回失败");
            }
            query.setcautionID(Long.valueOf(record.getCautionid()));//传递给query
            if (query.getsiteID2() != null) {
                for (Long x : query.getsiteID2()) {
                    ForceInvolve forceInvolve = new ForceInvolve();
                    forceInvolve.setCautionid(query.getcautionID());
                    forceInvolve.setSiteid(x);
                    forceInvolveService.insertForceInvolve(forceInvolve);//保存至参战力量表
                }
            }
        } else {
            record.setCautionid(query.getcautionID().toString());
            if (recordService.selectRecordList(record).isEmpty()){//查询二次推送的案件记录是否有变化
                recordService.updateRecord(record);//更新Record
            }
        }
        /**
         * 获取推送规则
         */
        if (query.getspecialType() != null) {
            ruleID = Long.valueOf("2");
        } else {
            ruleID = Long.valueOf("1");
        }
        Rule rule = ruleService.selectRuleByRuleid(ruleID);//根据通用或专项获取Rule
        /**
         * 开始信息推送
         */
        Set<String> excludeSet = new HashSet<String>();//统计前端已勾选的部分
        if (query.getinform() != null)//排除前端已勾选部分
        {
            for (Kinfo k : query.getinform()) {
                if (k.getinformID() != null && k.getlibraryType() != null) {
                    excludeSet.add(k.getlibraryType().toString() + ":" + k.getinformID().toString());
                }
            }
        }
        if (rule.getGeneralnum() > 0)//添加通用提示信息至候选列表krlist
        {
            Knowledge knowledge = new Knowledge();
            knowledge.setDisastertype("" + query.getdistype());
            knowledge.setDetailtype(query.getgeneralType());
            knowledge.setInform(query.getkeyWords());
            List<Knowledge> klist = new ArrayList<Knowledge>();
            if (knowledge.getDetailtype()!=null){
                klist=knowledgeService.selectKnowledgeList(knowledge);//已知详细灾情类型
            } else {
                TypeRelation typeRelation=  new TypeRelation();
                typeRelation.setDisposeobj(query.getdisposeObj());//未知详细灾情类型，则根据处置对象进行关联
                List<TypeRelation> typeRelations = typeRelationService.selectTypeRelationList(typeRelation);
                List<Long> detailtypelist = new ArrayList<Long>();
                if(typeRelation!=null){
                    for(TypeRelation t:typeRelations){
                        detailtypelist.add(t.getDetailtype());
                    }
                }                
                if(detailtypelist!=null){
                    for(Long d : detailtypelist){
                        knowledge.setDetailtype(d);
                        klist.addAll(knowledgeService.selectKnowledgeList(knowledge));
                    }
                }
            }
            if (klist != null)//匹配结果非空
            {
                for (Knowledge k : klist) {
                    if (!excludeSet.contains("1:" + k.getInformid().toString()))//已勾选信息的去除
                    {
                        kinfo = new Kinfo();
                        kinfo.setinformID(k.getInformid());
                        kinfo.setinform(k.getInform());
                        kinfo.setlibraryType(1);
                        krlist.add(kinfo);
                    }
                }
                if (krlist.size() <= rule.getGeneralnum())//候选数量小于等于需发送数量则全部添加至待发送列表
                {
                    clist.addAll(krlist);
                    krlist.clear();
                }
            }
        }
        if (rule.getSpecialnum() > 0)//添加专项提示信息至候选列表srlist
        {
            Special special = new Special();
            special.setDetailtype(query.getspecialType());
            special.setInform(query.getkeyWords());
            List<Special> slist = specialService.selectSpecialList(special);
            if (slist != null)//匹配结果非空
            {
                for (Special s : slist) {
                    if (!excludeSet.contains("3:" + s.getInformid().toString()))//已勾选信息的去除
                    {
                        kinfo = new Kinfo();
                        kinfo.setinformID(Long.valueOf(s.getInformid().toString()));//专项ID数据类型是Integer
                        kinfo.setinform(s.getInform());
                        kinfo.setlibraryType(Integer.valueOf("3"));
                        srlist.add(kinfo);
                    }
                }
                if (srlist.size() <= rule.getSpecialnum())//候选数量小于等于需发送数量则全部添加至待发送列表
                {
                    clist.addAll(srlist);
                    srlist.clear();
                }
            }
        }
        if (safetynum > 0 || rule.getSecuritynum() > 0)//添加安全提示信息至候选列表sfrlist与sfrlist2
        {
            Long securitytype = Long.valueOf("-1");//推送的安全提示信息详细类型(非司通员) 社会救助无推送
            if (query.getdistype() == Long.valueOf("1")){//火灾推送
                securitytype = Long.valueOf("27");
            } else {
                if (query.getdistype() == Long.valueOf("2")){//抢险救援推送
                    securitytype = Long.valueOf("28");
                }
            }
            Security security = new Security();
            security.setSecuritypeid(query.getsecurityType());
            security.setInform(query.getkeyWords());
            List<Security> sflist = securityService.selectSecurityList(security);
            if (sflist != null)//匹配结果非空
            {
                for (Security sf : sflist) {
                    if (!excludeSet.contains("2:" + sf.getInformid().toString()))//已勾选信息的去除
                    {
                        kinfo = new Kinfo();
                        kinfo.setinformID(Long.valueOf(sf.getInformid().toString()));//安全提示信息ID数据类型为Integer
                        kinfo.setinform(sf.getInform());
                        kinfo.setlibraryType(Integer.valueOf("2"));
                        if (sf.getSecuritypeid() == safetytypeid){
                            sfrlist2.add(kinfo);
                        } else {
                            if (sf.getSecuritypeid() == securitytype){
                                sfrlist.add(kinfo);
                            }
                        }
                    }
                }
                if (sfrlist.size() <= rule.getSecuritynum())//候选数量小于等于需发送数量则全部添加至待发送列表
                {
                    clist.addAll(sfrlist);
                    sfrlist.clear();
                }
                if (sfrlist2.size() <= safetynum)//候选数量小于等于需发送数量则全部添加至待发送列表
                {
                    clist2.addAll(sfrlist2);
                    sfrlist2.clear();
                }
            }
        }
        if (query.getinform() != null)//添加前端选择的提示信息至待发送列表
        {
            for (Kinfo k : query.getinform()) {
                clist.add(k);
            }
        }
        /**
         * 获取待推送用户列表
         */
        UserInfo user = new UserInfo();
        List<UserInfo> users = new ArrayList<UserInfo>();//待推送用户列表
        Set<String> excludeOpenidSet = new HashSet<String>();//待推送用户OpenID列表(司通员)
        user.setSiteid(query.getsiteID1());
        users = userInfoService.selectUserInfoList(user);
        if (query.getsiteID2() != null) {
            for (Long site : query.getsiteID2()) {
                user.setSiteid(site);
                users.addAll(userInfoService.selectUserInfoList(user));
            }
        }
        if (users == null || users.isEmpty()) {
            return AjaxResult.error("未能获取待推送用户列表");
        }
        for (UserInfo u : users) {
            if (u.getPositionid() == safetypositionid){
                excludeOpenidSet.add(u.getOpenid());
            }
        }
        /**
         * 推送提示信息并生成推送记录
         */
        Date time = new Date();//记录发送时间
        //Test
        List<TestTemplate> results = new ArrayList<TestTemplate>();//推送信息测试结果
        List<History> historyresult = new ArrayList<History>();//History表生成测试结果
        List<String> wxresult = new ArrayList<String>();//微信小程序推送测试结果
        //Test
        for (UserInfo u : users) {
            //Test,Add openid
            TestTemplate result = new TestTemplate();
            String informtext = new String();
            result.openid = u.getOpenid();
            //Test,Add record data
            if (record.getCautionid() != null) {
                result.record.put("cautionID", record.getCautionid());
            } else {
                result.record.put("cautionID", "");
            }
            if (record.getLocation() != null) {
                result.record.put("address", record.getLocation());
            } else {
                result.record.put("address", "");
            }
            if (record.getDistypeid() != null) {
                result.record.put("distype", record.getDistypeid().toString());
            } else {
                result.record.put("distype", "");
            }
            if (record.getCautiontime() != null) {
                result.record.put("date", record.getCautiontime().toString());
            } else {
                result.record.put("date", "");
            }
            //Test      
            /**
             * 推送信息选取
             */
            List<Kinfo> randomlist = new ArrayList<Kinfo>();//用户独特推送信息列表
            if (excludeOpenidSet.contains(u.getOpenid()))
            {
                List<Integer> sfindex = randomindex(sfrlist2.size(), safetynum);
                for (Integer i : sfindex) {
                    randomlist.add(sfrlist2.get(i));
                }
            } 
            else 
            {
                List<Integer> kindex = randomindex(krlist.size(), rule.getGeneralnum());
                List<Integer> sindex = randomindex(srlist.size(), rule.getSpecialnum());
                List<Integer> sfindex = randomindex(sfrlist.size(), rule.getSecuritynum());
                for (Integer i : kindex) {
                    randomlist.add(krlist.get(i));
                }
                for (Integer i : sindex) {
                    randomlist.add(srlist.get(i));
                }
                for (Integer i : sfindex) {
                    randomlist.add(sfrlist.get(i));
                }
            }
            /**
             * 生成推送记录
             */
            if (excludeOpenidSet.contains(u.getOpenid()))//公共推送信息列表推送
            {
                if (clist2 != null)
                {
                    for (Kinfo info : clist2) {
                        if (info.getinformID() != null)//生成推送记录
                        {
                            History history = new History();
                            history.setCautionid(query.getcautionID().toString());
                            history.setSendtime(time);
                            history.setTele(u.getTele());
                            history.setInformid(info.getinformID().toString());
                            history.setLibrarytype(info.librarytype);
                            historyService.insertHistory(history);//插入推送记录表
                            //Test
                            historyresult.add(history);
                            //Test
                        }
                        if (informtext != null && !informtext.isEmpty()) {
                            informtext = informtext + "+" + info.getinform();
                        } else {
                            informtext = info.getinform();
                        }
                        //Test
                        result.inform.add(info);
                        //Test
                    }
                }
            }
            else
            {
                if (clist != null)
                {
                    for (Kinfo info : clist) {
                        if (info.getinformID() != null) //生成推送记录
                        {
                            History history = new History();
                            history.setCautionid(query.getcautionID().toString());
                            history.setSendtime(time);
                            history.setTele(u.getTele());
                            history.setInformid(info.getinformID().toString());
                            history.setLibrarytype(info.librarytype);
                            historyService.insertHistory(history);//插入推送记录表
                            //Test
                            historyresult.add(history);
                            //Test
                        }
                        if (informtext != null && !informtext.isEmpty()) {
                            informtext = informtext + "+" + info.getinform();
                        } else {
                            informtext = info.getinform();
                        }
                        //Test
                        result.inform.add(info);
                        //Test
                    }
                }
            }
            if (randomlist != null)//用户独特推送信息列表推送
            {
                for (Kinfo info : randomlist) 
                {
                    if (info.getinformID() != null)//生成推送记录
                    {
                        History history = new History();
                        history.setCautionid(query.getcautionID().toString());
                        history.setSendtime(time);
                        history.setTele(u.getTele());
                        history.setInformid(info.getinformID().toString());
                        history.setLibrarytype(info.librarytype);
                        historyService.insertHistory(history);//插入推送记录表
                        //Test
                        historyresult.add(history);
                        //Test
                    }
                    if (informtext != null && !informtext.isEmpty()) {
                        informtext = informtext + "+" + info.getinform();
                    } else {
                        informtext = info.getinform();
                    }
                    //Test
                    result.inform.add(info);
                    //Test
                }
            }
            /**
             * 推送至小程序
             */
            Map<String, TemplateData> m = new HashMap<>(3);
            if (record.getLocation().length() > 19) {
                m.put("thing4", new TemplateData(record.getLocation().substring(0, 19)));
            } else {
                m.put("thing4", new TemplateData(record.getLocation()));
            }
            if (disasterTypeService.selectDisasterTypeByTypeid(record.getDistypeid()).getTypename().length() > 19) {
                m.put("thing3", new TemplateData(disasterTypeService.selectDisasterTypeByTypeid(record.getDistypeid()).getTypename().substring(0, 19)));
            } else {
                m.put("thing3", new TemplateData(disasterTypeService.selectDisasterTypeByTypeid(record.getDistypeid()).getTypename()));
            }
            if (informtext.length() > 19) {
                m.put("thing6", new TemplateData(informtext.substring(0, 19)));
            } else {
                m.put("thing6", new TemplateData(informtext));
            }
            String page = "pages/message/push_message?type=" + disasterTypeService.selectDisasterTypeByTypeid(record.getDistypeid()).getTypename() + "&time=" + record.getCautiontime() + "&address=" + record.getLocation() + "&message=" + informtext;
            //sendMessage.push(u.openID,m,page);
            //Test
            wxresult.add(sendMessage.push(u.getOpenid(), m, page));//微信小程序推送
            results.add(result);
            //Test

            /*
             * 推送至企业微信
             * */
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String[] text = informtext.split("\\+");
            String text_send = "";
            for(int i = 1;i < text.length + 1;i++){
                text_send = text_send + "+" + i + "、" + text[i-1];
            }
            String message = "案发地址：" + record.getLocation() + "\n" + "立案时间：" + df.format(new Date()) + "\n"
                            +"灾情类型：" + disasterTypeService.selectDisasterTypeByTypeid(record.getDistypeid()).getTypename() + "\n" + "知识内容：" + text_send.replaceAll("\\+","\n");
            sendtowechat_com.send(userInfoMatchingService.selectUserIDbyOpenID(u.getOpenid()),message);
//            sendtowechat_com.send(userInfoMatchingService.selectUserIDbyOpenID(u.openID),"ceshi1109");
        }
        return AjaxResult.success(wxresult);//返回结果：historyresult-历史表生成记录;results-用户推送记录;wxresult-实际用户推送反馈;
    }

}
