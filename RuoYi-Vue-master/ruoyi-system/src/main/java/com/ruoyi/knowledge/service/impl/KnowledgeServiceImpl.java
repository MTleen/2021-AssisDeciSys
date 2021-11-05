package com.ruoyi.knowledge.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.KnowledgeMapper;
import com.ruoyi.knowledge.domain.Knowledge;
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.domain.Kwords;
import com.ruoyi.knowledge.domain.Rule;
import com.ruoyi.knowledge.service.IKnowledgeService;

/**
 * 提示信息表Service业务层处理
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@Service
public class KnowledgeServiceImpl implements IKnowledgeService 
{
    @Autowired
    private KnowledgeMapper knowledgeMapper;

    /**
     * 查询提示信息表
     * 
     * @param informid 提示信息表主键
     * @return 提示信息表
     */
    @Override
    public Knowledge selectKnowledgeByInformid(Long informid)
    {
        return knowledgeMapper.selectKnowledgeByInformid(informid);
    }

    /**
     * 查询提示信息表列表
     * 
     * @param knowledge 提示信息表
     * @return 提示信息表
     */
    @Override
    public List<Knowledge> selectKnowledgeList(Knowledge knowledge)
    {
        return knowledgeMapper.selectKnowledgeList(knowledge);
    }

    /**
     * 查询规则列表
     * 
     * @return 规则表
     */
    @Override
    public List<Rule> selectRuleList()
    {
        return knowledgeMapper.selectRuleList();
    }

    /**
     * 匹配提示信息
     * 
     * @param kwords 提示信息表
     * @return 提示信息表
     */
    @Override
    public List<Knowledge> matchKnowledgeList(Kwords kwords)
    {
        return knowledgeMapper.matchKnowledgeList(kwords);
    }

    /**
     * 岗位与所属消防车查询
     * 
     * @param openid 用户OpenID
     * @return PositionID 与 TruckID
     */
    @Override
    public String selectPositionIDbyOpenID(Long openid)
    {
        return knowledgeMapper.selectPositionIDbyOpenID(openid);
    }
    @Override
    public String selectTruckIDbyOpenID(Long openid)
    {
        return knowledgeMapper.selectTruckIDbyOpenID(openid);
    }

    /**
     * 案件记录查询
     * 
     * @param truckid,time 消防车ID, 截止时间
     * @return 案件记录表
     */
    @Override
    public List<Record> selectRecord(String truckid, String time)
    {
        return knowledgeMapper.selectRecord(truckid, time);
    }

    /**
     * 案件发送的提示信息的时间查询
     * 
     * @param cautionid,positionid 案件记录ID, 岗位
     * @return 发送时间
     */
    @Override
    public List<String> RecordSendtimeCount(String cautionid, String positionid)
    {
        return knowledgeMapper.RecordSendtimeCount(cautionid,positionid);
    }

    /**
     * 案件发送的提示信息查询
     * 
     * @param cautionid,positionid,time 案件记录ID, 岗位, 发送时间
     * @return 提示信息表
     */
    @Override
    public List<Knowledge> selectKnowledge4App(String cautionid, String positionid, String time)
    {
        List<Knowledge> result=new ArrayList<Knowledge>();
        List<String> informID=knowledgeMapper.selectinformID(cautionid,positionid,time);
        for(String x:informID){
            result.add(knowledgeMapper.selectKnowledgeByInformid(Long.valueOf(x)));
        }
        return result;
    }

    /**
     * 新增提示信息表
     * 
     * @param knowledge 提示信息表
     * @return 结果
     */
    @Override
    public int insertKnowledge(Knowledge knowledge)
    {
        return knowledgeMapper.insertKnowledge(knowledge);
    }

    /**
     * 修改提示信息表
     * 
     * @param knowledge 提示信息表
     * @return 结果
     */
    @Override
    public int updateKnowledge(Knowledge knowledge)
    {
        return knowledgeMapper.updateKnowledge(knowledge);
    }

    /**
     * 批量删除提示信息表
     * 
     * @param informids 需要删除的提示信息表主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgeByInformids(Long[] informids)
    {
        return knowledgeMapper.deleteKnowledgeByInformids(informids);
    }

    /**
     * 删除提示信息表信息
     * 
     * @param informid 提示信息表主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgeByInformid(Long informid)
    {
        return knowledgeMapper.deleteKnowledgeByInformid(informid);
    }
}
