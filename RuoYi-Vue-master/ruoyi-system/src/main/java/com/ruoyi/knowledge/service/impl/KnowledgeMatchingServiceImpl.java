package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.mapper.KnowledgeMatchingMapper;
import com.ruoyi.knowledge.service.IKnowledgeMatchingService;

/**
 * 信息推送Service业务处理
 *
 * @author MP5Leader
 * @date 2021-11-09
 */
@Service
public class KnowledgeMatchingServiceImpl implements IKnowledgeMatchingService
{
    @Autowired
    private KnowledgeMatchingMapper knowledgeMatchingMapper;

    /**
     * 用户表查询替代
     *
     * @param siteid 所属队站
     * @return openID列表
     */
    @Override
    public List<String> selectUserOpenIDbySiteID(Long siteid)
    {
        return knowledgeMatchingMapper.selectUserOpenIDbySiteID(siteid);
    }

    /**
     * 用户表查询替代
     *
     * @param openid openid
     * @return 手机号
     */
    @Override
    public String selectUserTelebyOpenID(String openid)
    {
        return knowledgeMatchingMapper.selectUserTelebyOpenID(openid);
    }

    /**
     * 用户表查询替代
     *
     * @param openid openid
     * @return 岗位ID
     */
    @Override
    public Long selectUserPositionIDbyOpenID(String openid)
    {
        return knowledgeMatchingMapper.selectUserPositionIDbyOpenID(openid);
    }

    /**
     * 新增出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    @Override
    public int insertRecord(Record record)
    {
        return knowledgeMatchingMapper.insertRecord(record);
    }
}