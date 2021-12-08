package com.ruoyi.knowledge.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.knowledge.domain.*;
import com.ruoyi.knowledge.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.KnowledgeMapper;
import com.ruoyi.knowledge.service.IKnowledgeService;
import com.ruoyi.knowledge.mapper.TypeRelationMapper;
import com.ruoyi.knowledge.service.ITypeRelationService;

/**
 * 通用知识库Service业务层处理
 *
 * @author Mathripper
 * @date 2021-11-06
 */
@Service
public class KnowledgeServiceImpl implements IKnowledgeService {
    @Autowired
    private KnowledgeMapper knowledgeMapper;
    private TypeRelationMapper typeRelationMapper;

    /**
     * 查询通用知识库
     *
     * @param informid 通用知识库主键
     * @return 通用知识库
     */
    @Override
    public Knowledge selectKnowledgeByInformid(Long informid) {
        return knowledgeMapper.selectKnowledgeByInformid(informid);
    }

    /**
     * 查询通用知识库列表
     *
     * @param knowledge 通用知识库
     * @return 通用知识库
     */
    @Override
    public List<Knowledge> selectKnowledgeList(Knowledge knowledge) {
        return knowledgeMapper.selectKnowledgeList(knowledge);
    }

    /**
     * 新增通用知识库
     *
     * @param knowledge 通用知识库
     * @return 结果
     */
    @Override
    public int insertKnowledge(Knowledge knowledge) {
        return knowledgeMapper.insertKnowledge(knowledge);
    }

    /**
     * 修改通用知识库
     *
     * @param knowledge 通用知识库
     * @return 结果
     */
    @Override
    public int updateKnowledge(Knowledge knowledge) {

        return knowledgeMapper.updateKnowledge(knowledge);
    }

    /**
     * 批量删除通用知识库
     *
     * @param informids 需要删除的通用知识库主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgeByInformids(Long[] informids) {
        return knowledgeMapper.deleteKnowledgeByInformids(informids);
    }

    /**
     * 删除通用知识库信息
     *
     * @param informid 通用知识库主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgeByInformid(Long informid) {
        return knowledgeMapper.deleteKnowledgeByInformid(informid);
    }

    /**
     * 小程序信息查询
     *
     * @return 结果
     */
    @Override
    public String selecttelebyOpenID(String openid) {
        return knowledgeMapper.selecttelebyOpenID(openid);
    }

    @Override
    public Boolean selectStatusbyCaution(String cautionid) {
        return knowledgeMapper.selectStatusbyCaution(cautionid);
    }

    @Override
    public List<History> selectLibrarybyCaution(String cautionid, String tele, Date sendtime) {
        return knowledgeMapper.selectLibrarybyCaution(cautionid, tele, sendtime);
    }

    @Override
    public List<History> selectCautionbytele(String tele) {
        return knowledgeMapper.selectCautionbytele(tele);
    }

    @Override
    public String selectDisaster(String disastertype) {
        return knowledgeMapper.selectDisaster(disastertype);
    }

    @Override
    public List<History> selectInformIDbytele(String tele, String cautionid, Date sendtime) {
        return knowledgeMapper.selectInformIDbytele(tele, cautionid, sendtime);
    }
//    @Override
//    public List<History> selectInformIDbytele(String tele, String cautionid,Date sendtime,Integer library)
//    {
//        return knowledgeMapper.selectInformIDbytele(tele,cautionid,sendtime,library);
//    }

    @Override
    public List<History> selectInformIDbycau(String tele, String cautionid, Date sendtime, Integer library) {
        return knowledgeMapper.selectInformIDbycau(tele, cautionid, sendtime, library);
    }

    @Override
    public List<History> selectInformIDbytele1(String tele, String cautionid, Date sendtime, Integer library) {
        return knowledgeMapper.selectInformIDbytele1(tele, cautionid, sendtime, library);
    }

    @Override
    public List<Knowledge> selectKnow1(Long informid) {
        return knowledgeMapper.selectKnow1(informid);
    }

    @Override
    public List<Security> selectKnow2(Long informid) {
        return knowledgeMapper.selectKnow2(informid);
    }

    @Override
    public List<Special> selectKnow3(Long informid) {
        return knowledgeMapper.selectKnow3(informid);
    }

    @Override
    public List<Record> selectRecord1(String tele, Date sendtime1) {
        return knowledgeMapper.selectRecord1(tele, sendtime1);
    }

    @Override
    public List<Record> selectRecord2(String cautionid) {
        return knowledgeMapper.selectRecord2(cautionid);
    }
}