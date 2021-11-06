package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.History;

/**
 * 信息历史Service接口
 *
 * @author Mathripper
 * @date 2021-11-06
 */
public interface IHistoryService
{
    /**
     * 查询信息历史
     *
     * @param index 信息历史主键
     * @return 信息历史
     */
    public History selectHistoryByIndex(Long index);

    /**
     * 查询信息历史列表
     *
     * @param history 信息历史
     * @return 信息历史集合
     */
    public List<History> selectHistoryList(History history);

    /**
     * 新增信息历史
     *
     * @param history 信息历史
     * @return 结果
     */
    public int insertHistory(History history);

    /**
     * 修改信息历史
     *
     * @param history 信息历史
     * @return 结果
     */
    public int updateHistory(History history);

    /**
     * 批量删除信息历史
     *
     * @param indexs 需要删除的信息历史主键集合
     * @return 结果
     */
    public int deleteHistoryByIndexs(Long[] indexs);

    /**
     * 删除信息历史信息
     *
     * @param index 信息历史主键
     * @return 结果
     */
    public int deleteHistoryByIndex(Long index);
}