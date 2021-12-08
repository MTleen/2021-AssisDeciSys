package com.ruoyi.knowledge.service.impl;

import java.util.List;

import com.ruoyi.knowledge.domain.TypeRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.DetailTypeMapper;
import com.ruoyi.knowledge.domain.DetailType;
import com.ruoyi.knowledge.service.IDetailTypeService;
import com.ruoyi.knowledge.mapper.TypeRelationMapper;

/**
 * 详细类型表Service业务层处理
 *
 * @author Mathripper
 * @date 2021-11-05
 */
@Service
public class DetailTypeServiceImpl implements IDetailTypeService {
    @Autowired
    private DetailTypeMapper detailTypeMapper;
    @Autowired
    private TypeRelationMapper typeRelationMapper;

    /**
     * 查询详细类型表
     *
     * @param typeid 详细类型表主键
     * @return 详细类型表
     */
    @Override
    public DetailType selectDetailTypeByTypeid(Long typeid) {
        return detailTypeMapper.selectDetailTypeByTypeid(typeid);
    }

    /**
     * 查询详细类型表列表
     *
     * @param detailType 详细类型表
     * @return 详细类型表
     */
    @Override
    public List<DetailType> selectDetailTypeList(DetailType detailType) {
        return detailTypeMapper.selectDetailTypeList(detailType);
    }

    /**
     * 新增详细类型表
     *
     * @param detailType 详细类型表
     * @return 结果
     */
    @Override
    public int insertDetailType(DetailType detailType) {
        // 循环插入 TypeRelation 记录
        updateTypeRelation(detailType);
        return detailTypeMapper.insertDetailType(detailType);
    }

    /**
     * 修改详细类型表
     *
     * @param detailType 详细类型表
     * @return 结果
     */
    @Override
    public int updateDetailType(DetailType detailType) {
        if(detailType.getTypeid()!= null){
            typeRelationMapper.deleteTypeRelationByDetailType(detailType.getTypeid());
        }
        // 循环插入 TypeRelation 记录
        updateTypeRelation(detailType);
        return detailTypeMapper.updateDetailType(detailType);
    }

    @Override
    public void updateTypeRelation(DetailType detailType){
        if (detailType.getDisposeobjList() != null) {
            for (String dispobj : detailType.getDisposeobjList()) {
                TypeRelation tr = new TypeRelation();
                tr.setDisposeobj(Long.parseLong(dispobj));
                tr.setDetailtype(detailType.getTypeid());
                typeRelationMapper.insertTypeRelation(tr);
            }
        }
    }
    /**
     * 批量删除详细类型表
     *
     * @param typeids 需要删除的详细类型表主键
     * @return 结果
     */
    @Override
    public int deleteDetailTypeByTypeids(Long[] typeids) {
        return detailTypeMapper.deleteDetailTypeByTypeids(typeids);
    }

    /**
     * 删除详细类型表信息
     *
     * @param typeid 详细类型表主键
     * @return 结果
     */
    @Override
    public int deleteDetailTypeByTypeid(Long typeid) {
        return detailTypeMapper.deleteDetailTypeByTypeid(typeid);
    }
}