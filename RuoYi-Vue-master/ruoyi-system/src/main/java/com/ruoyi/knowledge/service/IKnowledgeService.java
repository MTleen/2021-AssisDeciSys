package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.Knowledge;
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.domain.Rule;
import com.ruoyi.knowledge.domain.Kwords;

/**
 * 提示信息表Service接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface IKnowledgeService 
{
    /**
     * 查询提示信息表
     * 
     * @param informid 提示信息表主键
     * @return 提示信息表
     */
    public Knowledge selectKnowledgeByInformid(Long informid);

    /**
     * 查询提示信息表列表
     * 
     * @param knowledge 提示信息表
     * @return 提示信息表集合
     */
    public List<Knowledge> selectKnowledgeList(Knowledge knowledge);

    /**
     * 查询提示信息表列表
     * 
     * @return 规则表集合
     */
    public List<Rule> selectRuleList();
    
    /**
     * 匹配提示信息表
     * 
     * @param kwords 提示信息表
     * @return 提示信息表集合
     */
    public List<Knowledge> matchKnowledgeList(Kwords kwords);

    /**
     * 岗位与所属消防车查询
     * 
     * @param openid 用户OpenID
     * @return PositionID 与 TruckID
     */
    public String selectPositionIDbyOpenID(Long openid);
    public String selectTruckIDbyOpenID(Long openid);

    /**
     * 案件记录查询
     * 
     * @param truckid,time 消防车ID, 截止时间
     * @return 案件记录表
     */
    public List<Record> selectRecord(String truckid, String time);

    /**
     * 案件发送的提示信息的时间统计
     * 
     * @param cautionid,positionid 案件记录ID, 岗位
     * @return 发送时间
     */
    public List<String> RecordSendtimeCount(String cautionid, String positionid);

    /**
     * 案件发送的提示信息查询
     * 
     * @param cautionid,positionid,time 案件记录ID, 岗位, 发送时间
     * @return 提示信息表
     */
    public List<Knowledge> selectKnowledge4App(String cautionid, String positionid, String time);

    /**
     * 新增提示信息表
     * 
     * @param knowledge 提示信息表
     * @return 结果
     */
    public int insertKnowledge(Knowledge knowledge);

    /**
     * 修改提示信息表
     * 
     * @param knowledge 提示信息表
     * @return 结果
     */
    public int updateKnowledge(Knowledge knowledge);

    /**
     * 批量删除提示信息表
     * 
     * @param informids 需要删除的提示信息表主键集合
     * @return 结果
     */
    public int deleteKnowledgeByInformids(Long[] informids);

    /**
     * 删除提示信息表信息
     * 
     * @param informid 提示信息表主键
     * @return 结果
     */
    public int deleteKnowledgeByInformid(Long informid);
}
