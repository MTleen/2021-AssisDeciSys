package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.FeedBackMapper;
import com.ruoyi.knowledge.domain.FeedBack;
import com.ruoyi.knowledge.service.IFeedBackService;

/**
 * 反馈表Service业务层处理
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@Service
public class FeedBackServiceImpl implements IFeedBackService 
{
    @Autowired
    private FeedBackMapper feedBackMapper;

    /**
     * 查询反馈表
     * 
     * @param feedid 反馈表主键
     * @return 反馈表
     */
    @Override
    public FeedBack selectFeedBackByFeedid(Long feedid)
    {
        return feedBackMapper.selectFeedBackByFeedid(feedid);
    }

    /**
     * 查询反馈表列表
     * 
     * @param feedBack 反馈表
     * @return 反馈表
     */
    @Override
    public List<FeedBack> selectFeedBackList(FeedBack feedBack)
    {
        return feedBackMapper.selectFeedBackList(feedBack);
    }

    /**
     * 新增反馈表
     * 
     * @param feedBack 反馈表
     * @return 结果
     */
    @Override
    public int insertFeedBack(FeedBack feedBack)
    {
        return feedBackMapper.insertFeedBack(feedBack);
    }

    /**
     * 修改反馈表
     * 
     * @param feedBack 反馈表
     * @return 结果
     */
    @Override
    public int updateFeedBack(FeedBack feedBack)
    {
        return feedBackMapper.updateFeedBack(feedBack);
    }

    /**
     * 批量删除反馈表
     * 
     * @param feedids 需要删除的反馈表主键
     * @return 结果
     */
    @Override
    public int deleteFeedBackByFeedids(Long[] feedids)
    {
        return feedBackMapper.deleteFeedBackByFeedids(feedids);
    }

    /**
     * 删除反馈表信息
     * 
     * @param feedid 反馈表主键
     * @return 结果
     */
    @Override
    public int deleteFeedBackByFeedid(Long feedid)
    {
        return feedBackMapper.deleteFeedBackByFeedid(feedid);
    }
}
