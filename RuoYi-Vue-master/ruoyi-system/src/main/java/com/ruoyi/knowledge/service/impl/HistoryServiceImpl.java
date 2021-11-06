package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.HistoryMapper;
import com.ruoyi.knowledge.domain.History;
import com.ruoyi.knowledge.service.IHistoryService;

/**
 * 信息历史Service业务层处理
 *
 * @author Mathripper
 * @date 2021-11-06
 */
@Service
public class HistoryServiceImpl implements IHistoryService
{
    @Autowired
    private HistoryMapper historyMapper;

    /**
     * 查询信息历史
     *
     * @param index 信息历史主键
     * @return 信息历史
     */
    @Override
    public History selectHistoryByIndex(Long index)
    {
        return historyMapper.selectHistoryByIndex(index);
    }

    /**
     * 查询信息历史列表
     *
     * @param history 信息历史
     * @return 信息历史
     */
    @Override
    public List<History> selectHistoryList(History history)
    {
        return historyMapper.selectHistoryList(history);
    }

    /**
     * 新增信息历史
     *
     * @param history 信息历史
     * @return 结果
     */
    @Override
    public int insertHistory(History history)
    {
        return historyMapper.insertHistory(history);
    }

    /**
     * 修改信息历史
     *
     * @param history 信息历史
     * @return 结果
     */
    @Override
    public int updateHistory(History history)
    {
        return historyMapper.updateHistory(history);
    }

    /**
     * 批量删除信息历史
     *
     * @param indexs 需要删除的信息历史主键
     * @return 结果
     */
    @Override
    public int deleteHistoryByIndexs(Long[] indexs)
    {
        return historyMapper.deleteHistoryByIndexs(indexs);
    }

    /**
     * 删除信息历史信息
     *
     * @param index 信息历史主键
     * @return 结果
     */
    @Override
    public int deleteHistoryByIndex(Long index)
    {
        return historyMapper.deleteHistoryByIndex(index);
    }
}