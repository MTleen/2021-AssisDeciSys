package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.FeedBack;

/**
 * 反馈表Service接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface IFeedBackService 
{
    /**
     * 查询反馈表
     * 
     * @param feedid 反馈表主键
     * @return 反馈表
     */
    public FeedBack selectFeedBackByFeedid(Long feedid);

    /**
     * 查询反馈表列表
     * 
     * @param feedBack 反馈表
     * @return 反馈表集合
     */
    public List<FeedBack> selectFeedBackList(FeedBack feedBack);

    /**
     * 新增反馈表
     * 
     * @param feedBack 反馈表
     * @return 结果
     */
    public int insertFeedBack(FeedBack feedBack);

    /**
     * 修改反馈表
     * 
     * @param feedBack 反馈表
     * @return 结果
     */
    public int updateFeedBack(FeedBack feedBack);

    /**
     * 批量删除反馈表
     * 
     * @param feedids 需要删除的反馈表主键集合
     * @return 结果
     */
    public int deleteFeedBackByFeedids(Long[] feedids);

    /**
     * 删除反馈表信息
     * 
     * @param feedid 反馈表主键
     * @return 结果
     */
    public int deleteFeedBackByFeedid(Long feedid);
}
