package com.ruoyi.knowledge.mapper;

import java.util.List;
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
     * 用户表查询替代
     *
     * @param siteid 所属队站
     * @return 手机号列表
     */
    public List<String> selectUserTelebySiteID(Long siteid);

    /**
     * 用户表查询替代
     *
     * @param siteid 所属队站
     * @return openID列表
     */
    public List<String> selectUserOpenIDbySiteID(Long siteid);

    /**
     * 用户表查询替代
     *
     * @param openid openid
     * @return 手机号
     */
    public String selectUserTelebyOpenID(String openid);

    /**
     * 新增出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    public int insertRecord(Record record);

}