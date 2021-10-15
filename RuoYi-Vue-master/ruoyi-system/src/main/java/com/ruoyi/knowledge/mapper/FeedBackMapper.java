package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.FeedBack;

/**
 * 反馈表Mapper接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface FeedBackMapper 
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
     * 删除反馈表
     * 
     * @param feedid 反馈表主键
     * @return 结果
     */
    public int deleteFeedBackByFeedid(Long feedid);

    /**
     * 批量删除反馈表
     * 
     * @param feedids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeedBackByFeedids(Long[] feedids);
}
