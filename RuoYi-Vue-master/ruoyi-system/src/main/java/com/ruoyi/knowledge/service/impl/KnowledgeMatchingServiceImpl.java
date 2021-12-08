package com.ruoyi.knowledge.service.impl;

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

    @Override
    public int insertRecord(Record record)
    {
        return knowledgeMatchingMapper.insertRecord(record);
    }
}