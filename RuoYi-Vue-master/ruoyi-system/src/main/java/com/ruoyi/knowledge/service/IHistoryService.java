package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.History;

/**
 * 历史表Service接口
 *
 * @author xiaoyu
 * @date 2021-10-29
 */
public interface IHistoryService
{
    /**
     * 查询历史表
     *
     * @param index 历史表主键
     * @return 历史表
     */
    public History selectHistoryByIndex(Long index);

    /**
     * 查询历史表列表
     *
     * @param history 历史表
     * @return 历史表集合
     */
    public List<History> selectHistoryList(History history);

    /**
     * 新增历史表
     *
     * @param history 历史表
     * @return 结果
     */
    public int insertHistory(History history);

    /**
     * 修改历史表
     *
     * @param history 历史表
     * @return 结果
     */
    public int updateHistory(History history);

    /**
     * 批量删除历史表
     *
     * @param indexs 需要删除的历史表主键集合
     * @return 结果
     */
    public int deleteHistoryByIndexs(Long[] indexs);

    /**
     * 删除历史表信息
     *
     * @param index 历史表主键
     * @return 结果
     */
    public int deleteHistoryByIndex(Long index);
}