package com.ruoyi.knowledge.mapper;

import com.ruoyi.knowledge.domain.Record;
/**
 * 信息推送Mapper接口
 *
 * @author MP5Leader
 * @date 2021-11-09
 */
public interface KnowledgeMatchingMapper
{
    /**
     * 新增出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    public int insertRecord(Record record);

}