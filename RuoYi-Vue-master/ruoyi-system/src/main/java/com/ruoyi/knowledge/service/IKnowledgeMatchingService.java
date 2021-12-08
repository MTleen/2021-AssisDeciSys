package com.ruoyi.knowledge.service;

import com.ruoyi.knowledge.domain.Record;

/**
 * 信息推送Service接口
 *
 * @author MP5Leader
 * @date 2021-11-09
 */
public interface IKnowledgeMatchingService
{
    /**
     * 新增出警记录表
     *
     * @param record 出警记录表
     * @return 生成的主键
     */
    public int insertRecord(Record record);   
 
}