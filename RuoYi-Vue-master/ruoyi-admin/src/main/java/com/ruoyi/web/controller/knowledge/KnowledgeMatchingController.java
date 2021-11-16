package com.ruoyi.web.controller.knowledge;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Date;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.knowledge.domain.*;
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.service.*;
import io.swagger.annotations.*;

/**
 * 信息推送Controller
 *
 * @author MP5Leader
 * @date 2021-11-09
 */
@Api("信息推送模块")
@RestController
@RequestMapping("/knowledge/match")
public class KnowledgeMatchingController  extends BaseController
{
    static class Userbackup//UserInfo表未完成前的替代品
    {
        String tele;//生成发送记录需要tele
        String openID;
    }
    static class TestTemplate//信息推送的测试结果
    {
        String openid;
        Map<String,String> record;
        List<Kinfo> inform;
        public TestTemplate()
        {
            openid=new String();
            record=new HashMap<String,String>();
            inform=new ArrayList<Kinfo>();
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
    private IRecordService recordService;

    @Autowired
    private IHistoryService historyService;

    /**
     * 随机生成推送列表
     * @param listsize 待推送列表长度
     * @param num 推送数量
     * @return 推送信息index列表
     */
    public List<Integer> randomindex(Integer listsize,Long num)
    {
        if (listsize<num)
        {
            return new ArrayList<Integer>();
        }
        List<Integer> result=new ArrayList<Integer>();
        Set<Integer> count=new HashSet<Integer>();
        Random random=new Random();
        while(count.size()<num)
        {
            count.add(random.nextInt(listsize));
        }
        for(Integer i:count)
        {
            result.add(i);
        }
        return result;
    }
 
    @ApiOperation("推送功能测试入口")
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
    @GetMapping("/test")
    public AjaxResult preprocess(Long cautionID,String address,Date date,Long distype,Long disposeObj,Long generalType,Long specialType,String keyWords,Long siteID1,Long siteID2_1,Long siteID2_2,Long k1id,String k1,Long k1type,Long k2id,String k2,Long k2type)
    {
        // Long cautionID; // 案件 ID，若为 null 表示该案件为新案件，需要存入 record 表，若不为空，说明是二次推送，不需要存入 record 表
		// String address; // 地址
		// String date; // 时间
		// Long distype; // 灾情类型（一级标签）
		// Long disposeObj; // 处置对象（二级标签）
		// Long generalType; // 通用类型（通用知识库，三级标签），专项类型和通用类型互斥，只能有一个不为空
		// Long specialType; // 专项类型（专项知识库）
		// Long securityType; // 安全类型（安全知识库）
		// String keyWords=null; // 关键词
		// Long siteID1; // 主管对站 ID
		List<Long> siteID2=new ArrayList<Long>(); // 参战对站 IDs，参数为一个 list，每个元素表示一个对战的 ID
        if (siteID2_1!=null){siteID2.add(siteID2_1);}
        if (siteID2_2!=null){siteID2.add(siteID2_2);}
        List<Kinfo> klist=new ArrayList<Kinfo>();
        if (k1!=null&&k1!=""){Kinfo info=new Kinfo();info.informID=k1id;info.inform=k1;info.libraryType=k1type;klist.add(info);}
        if (k2!=null&&k2!=""){Kinfo info=new Kinfo();info.informID=k2id;info.inform=k2;info.libraryType=k2type;klist.add(info);}

        Kwords query=new Kwords();
        query.setcautionID(cautionID);
        query.setaddress(address);
        query.setdate(date);
        query.setdistype(distype);
        query.setdisposeObj(disposeObj);
        query.setgeneralType(generalType);
        query.setspecialType(specialType);
        query.setkeyWords(keyWords);
        query.setsiteID1(siteID1);
        query.setsiteID2(siteID2);
        query.setinform(klist);

        //return AjaxResult.success(query);
        return distribution(query);
    }

    /**
     * 提示信息推送接口
     */
    @PreAuthorize("@ss.hasPermi('knowledge:knowledge:list')")
    @PostMapping("/distribution")
    public AjaxResult distribution(Kwords query)
    {
        List<Kinfo> krlist=new ArrayList<Kinfo>();//通用提示信息候选列表
        List<Kinfo> srlist=new ArrayList<Kinfo>();//专项提示信息候选列表
        List<Kinfo> sfrlist=new ArrayList<Kinfo>();//安全提示信息候选列表
        List<Kinfo> clist=new ArrayList<Kinfo>();//待发送的提示信息列表
        Kinfo kinfo;
        Long ruleID;

        /**
         * 分离query中案件记录部分
         */
        Record record=new Record();
        record.setCautiontime(query.getdate());
        record.setLocation(query.getaddress());
        record.setDistypeid(query.getdistype());          
        record.setDillobject(query.getdisposeObj());
        if(query.getspecialType()!=null)
        {
            record.setDetailtype(query.getspecialType());
        }
        else
        {
            if(query.getgeneralType()!=null)
            {
                record.setDetailtype(query.getgeneralType());
            }
            else
            {
                return AjaxResult.error("专项类型与通用类型不能都为空");
            }
        }
        record.setKeywords(query.getkeyWords());
        record.setSiteid(query.getsiteID1());
        String sites="";
        for(Long x:query.getsiteID2())
        {
            if(sites!="")
            {
                sites=sites+","+x.toString();
            }
            else
            {
                sites=x.toString();
            }
        }
        record.setSiteid2(sites);
        if(query.getcautionID()==null)//保存至Record
            {
                //knowledgeMatchingService.insertRecord(record);       //特殊方法写入Record表，返回生成的cautionID
                //Test
            if(record.getCautionid()==null){return AjaxResult.error("主键返回失败");}
            query.setcautionID(Long.valueOf(record.getCautionid()));//传递给query
        }
        /**
         * 获取推送规则
         */
        if(query.getspecialType()!=null)
        {ruleID=Long.valueOf("2");}
        else{ruleID=Long.valueOf("1");}
        Rule rule=ruleService.selectRuleByRuleid(ruleID);//根据通用或专项获取Rule
        /**
         * 开始信息推送
         */
        Set<String> excludeSet=new HashSet<String>() ;//统计前端已勾选的部分
        for(Kinfo k:query.getinform())//排除前端已勾选部分
        {
            if(k.getinformID()!=null&&k.getlibraryType()!=null)
            {
                excludeSet.add(k.getlibraryType().toString()+":"+k.getinformID().toString());
            }
        }
        if(rule.getGeneralnum()>0)//添加通用提示信息至候选列表krlist
        {
            Knowledge knowledge=new Knowledge();
            knowledge.setDisastertype(query.getdistype());
            knowledge.setDisposeobj(query.getdisposeObj());
            knowledge.setDetailtype(query.getgeneralType());
            knowledge.setInform(query.getkeyWords());
            List<Knowledge> klist = knowledgeService.selectKnowledgeList(knowledge);          
            for(Knowledge k:klist)
            {
                if(!excludeSet.contains("1:"+k.getInformid().toString()))//关键词筛选与已勾选信息的去除
                {
                    kinfo=new Kinfo();
                    kinfo.setinformID(k.getInformid());
                    kinfo.setinform(k.getInform());
                    kinfo.setlibraryType(Long.valueOf("1"));
                    krlist.add(kinfo);
                }
            }
            if(krlist.size()<=rule.getGeneralnum())//候选数量小于等于需发送数量则全部添加至待发送列表
            {
                clist.addAll(krlist);
                krlist.clear();
            }
        }
        if(rule.getSpecialnum()>0)//添加专项提示信息至候选列表srlist
        {
            Special special=new Special();
            special.setDetailtype(query.getspecialType());
            special.setInform(query.getkeyWords());
            List<Special> slist = specialService.selectSpecialList(special);          
            for(Special s:slist)
            {
                if(!excludeSet.contains("2:"+s.getInformid().toString()))//关键词筛选与已勾选信息的去除
                {
                    kinfo=new Kinfo();
                    kinfo.setinformID(Long.valueOf(s.getInformid().toString()));//专项ID数据类型是Integer
                    kinfo.setinform(s.getInform());
                    kinfo.setlibraryType(Long.valueOf("2"));
                    srlist.add(kinfo);
                }
            }
            if(srlist.size()<=rule.getSpecialnum())//候选数量小于等于需发送数量则全部添加至待发送列表
            {
                clist.addAll(srlist);
                srlist.clear();
            }
        }
        if(rule.getSecuritynum()>0)//添加安全提示信息至候选列表sfrlist
        {
            Security security=new Security();
            security.setSecuritypeid(query.getsecurityType());
            security.setInform(query.getkeyWords());
            List<Security> sflist = securityService.selectSecurityList(security);          
            for(Security sf:sflist)
            {
                if(!excludeSet.contains("3:"+sf.getInformid().toString()))//关键词筛选与已勾选信息的去除
                {
                    kinfo=new Kinfo();
                    kinfo.setinformID(Long.valueOf(sf.getInformid().toString()));//安全提示信息ID数据类型为Integer
                    kinfo.setinform(sf.getInform());
                    kinfo.setlibraryType(Long.valueOf("3"));
                    sfrlist.add(kinfo);
                }
            }
            if(sfrlist.size()<=rule.getSecuritynum())//候选数量小于等于需发送数量则全部添加至待发送列表
            {
                clist.addAll(sfrlist);
                sfrlist.clear();
            }
        }
        for(Kinfo k:query.getinform())//添加前端选择的提示信息至待发送列表
        {
            clist.add(k);
        }
        /**
         * 用户表查询替代
         */
        Userbackup user;
        List<String> olist=knowledgeMatchingService.selectUserOpenIDbySiteID(query.getsiteID1());//
        List<Userbackup> ulist=new ArrayList<Userbackup>();//
        for(String o:olist)
        {
            user=new Userbackup();
            user.openID=o;
            user.tele=knowledgeMatchingService.selectUserTelebyOpenID(o);
            ulist.add(user);
        }
        /**
         * 推送提示信息并生成推送记录
         */
        Date time=new Date();//记录发送时间
        List<TestTemplate> results=new ArrayList<TestTemplate>();//推送信息测试结果
        List<History> historyresult=new ArrayList<History>();//History表生成测试结果
        for(Userbackup u:ulist)
        {
            List<Kinfo> randomlist=new ArrayList<Kinfo>();//用户独特推送信息列表
            List<Integer> kindex=randomindex(krlist.size(),rule.getGeneralnum());
            List<Integer> sindex=randomindex(srlist.size(),rule.getSpecialnum());
            List<Integer> sfindex=randomindex(sfrlist.size(),rule.getSecuritynum());
            for(Integer i:kindex){randomlist.add(krlist.get(i));}
            for(Integer i:sindex){randomlist.add(srlist.get(i));}
            for(Integer i:sfindex){randomlist.add(sfrlist.get(i));}

            /**
             * 推送信息
             */


            //Test,Add openid
            TestTemplate result=new TestTemplate();
            result.openid=u.openID;
            //Test,Add record data
            if(record.getCautionid()!=null){result.record.put("cautionID",record.getCautionid());}else{result.record.put("cautionID","");}
            if(record.getLocation()!=null){result.record.put("address",record.getLocation());}else{result.record.put("address","");}
            if(record.getDistypeid()!=null){result.record.put("distype",record.getDistypeid().toString());}else{result.record.put("distype","");}
            if(record.getCautiontime()!=null){result.record.put("date",record.getCautiontime().toString());}else{result.record.put("date","");}
            //Test

            

            /**
             * 生成推送记录
             */
            for(Kinfo info:clist)//公共推送信息列表推送
            {
                History history=new History();
                history.setCautionid(query.getcautionID().toString());
                history.setSendtime(time);
                history.setTele(u.tele);
                if(info.getinformID()!=null){history.setInformid(info.getinformID().toString());}else{history.setInformid(null);}
                history.setLibrarytype(info.libraryType);
                //historyService.insertHistory(history);//生成推送记录
                //Test
                historyresult.add(history);
                //Test
                result.inform.add(info);
                //Test
            }
            for(Kinfo info:randomlist)//用户独特推送信息列表推送
            {
                History history=new History();
                history.setCautionid(query.getcautionID().toString());
                history.setSendtime(time);
                history.setTele(u.tele);
                if(info.getinformID()!=null){history.setInformid(info.getinformID().toString());}else{history.setInformid(null);}
                history.setLibrarytype(info.libraryType);
                //historyService.insertHistory(history);//生成推送记录
                //Test
                historyresult.add(history);
                //Test
                result.inform.add(info);
                //Test
            }
            //Test
            results.add(result);
            //Test
        }
        return AjaxResult.success(results);   
    }
    
}
