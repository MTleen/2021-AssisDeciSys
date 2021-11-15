package com.ruoyi.knowledge.service;

import java.util.Date;
import java.util.List;

import com.ruoyi.knowledge.domain.History;
import com.ruoyi.knowledge.domain.Knowledge;
import com.ruoyi.knowledge.domain.Record;

/**
 * 通用知识库Service接口
 *
 * @author Mathripper
 * @date 2021-11-06
 */
public interface IKnowledgeService
{
    /**
     * 查询通用知识库
     *
     * @param informid 通用知识库主键
     * @return 通用知识库
     */
    public Knowledge selectKnowledgeByInformid(Long informid);

    /**
     * 查询通用知识库列表
     *
     * @param knowledge 通用知识库
     * @return 通用知识库集合
     */
    public List<Knowledge> selectKnowledgeList(Knowledge knowledge);

    /**
     * 新增通用知识库
     *
     * @param knowledge 通用知识库
     * @return 结果
     */
    public int insertKnowledge(Knowledge knowledge);

    /**
     * 修改通用知识库
     *
     * @param knowledge 通用知识库
     * @return 结果
     */
    public int updateKnowledge(Knowledge knowledge);

    /**
     * 批量删除通用知识库
     *
     * @param informids 需要删除的通用知识库主键集合
     * @return 结果
     */
    public int deleteKnowledgeByInformids(Long[] informids);

    /**
     * 删除通用知识库信息
     *
     * @param informid 通用知识库主键
     * @return 结果
     */
    public int deleteKnowledgeByInformid(Long informid);

    /**
     * 小程序信息查询
     *
     * @param openid 用户OpenID
     * @return PositionID 与 TruckID
     */
    public String selecttelebyOpenID(String openid);
    public Boolean selectStatusbyCaution(String cautionid);
    public List<History> selectCautionbytele(String tele);
    public String selectDisaster(String disastertype);
    public List<History> selectInformIDbytele(String tele, Date sendtime, String cautionid);
    public List<History> selectInformIDbycau(String tele, String cautionid);
    public List<History> selectInformIDbytele1(String tele, Date sendtime);
    public List<Knowledge> selectKnow1(Long informid);
    public List<Record> selectRecord1(String tele, Date sendtime1);
    public List<Record> selectRecord2(String cautionid);
}