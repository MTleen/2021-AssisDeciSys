package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.HistoryMapper;
import com.ruoyi.knowledge.domain.History;
import com.ruoyi.knowledge.service.IHistoryService;

/**
 * 历史表Service业务层处理
 *
 * @author xiaoyu
 * @date 2021-10-29
 */
@Service
public class HistoryServiceImpl implements IHistoryService
{
    @Autowired
    private HistoryMapper historyMapper;

    /**
     * 查询历史表
     *
     * @param index 历史表主键
     * @return 历史表
     */
    @Override
    public History selectHistoryByIndex(Long index)
    {
        return historyMapper.selectHistoryByIndex(index);
    }

    /**
     * 查询历史表列表
     *
     * @param history 历史表
     * @return 历史表
     */
    @Override
    public List<History> selectHistoryList(History history)
    {
        return historyMapper.selectHistoryList(history);
    }

    /**
     * 新增历史表
     *
     * @param history 历史表
     * @return 结果
     */
    @Override
    public int insertHistory(History history)
    {
        return historyMapper.insertHistory(history);
    }

    /**
     * 修改历史表
     *
     * @param history 历史表
     * @return 结果
     */
    @Override
    public int updateHistory(History history)
    {
        return historyMapper.updateHistory(history);
    }

    /**
     * 批量删除历史表
     *
     * @param indexs 需要删除的历史表主键
     * @return 结果
     */
    @Override
    public int deleteHistoryByIndexs(Long[] indexs)
    {
        return historyMapper.deleteHistoryByIndexs(indexs);
    }

    /**
     * 删除历史表信息
     *
     * @param index 历史表主键
     * @return 结果
     */
    @Override
    public int deleteHistoryByIndex(Long index)
    {
        return historyMapper.deleteHistoryByIndex(index);
    }
}