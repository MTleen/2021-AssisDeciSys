package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.DisposeObjMapper;
import com.ruoyi.knowledge.domain.DisposeObj;
import com.ruoyi.knowledge.service.IDisposeObjService;

/**
 * 处置对象Service业务层处理
 *
 * @author Mathripper
 * @date 2021-11-05
 */
@Service
public class DisposeObjServiceImpl implements IDisposeObjService
{
    @Autowired
    private DisposeObjMapper disposeObjMapper;

    /**
     * 查询处置对象
     *
     * @param objid 处置对象主键
     * @return 处置对象
     */
    @Override
    public DisposeObj selectDisposeObjByObjid(Long objid)
    {
        return disposeObjMapper.selectDisposeObjByObjid(objid);
    }

    /**
     * 查询处置对象列表
     *
     * @param disposeObj 处置对象
     * @return 处置对象
     */
    @Override
    public List<DisposeObj> selectDisposeObjList(DisposeObj disposeObj)
    {
        return disposeObjMapper.selectDisposeObjList(disposeObj);
    }

    /**
     * 新增处置对象
     *
     * @param disposeObj 处置对象
     * @return 结果
     */
    @Override
    public int insertDisposeObj(DisposeObj disposeObj)
    {
        return disposeObjMapper.insertDisposeObj(disposeObj);
    }

    /**
     * 修改处置对象
     *
     * @param disposeObj 处置对象
     * @return 结果
     */
    @Override
    public int updateDisposeObj(DisposeObj disposeObj)
    {
        return disposeObjMapper.updateDisposeObj(disposeObj);
    }

    /**
     * 批量删除处置对象
     *
     * @param objids 需要删除的处置对象主键
     * @return 结果
     */
    @Override
    public int deleteDisposeObjByObjids(Long[] objids)
    {
        return disposeObjMapper.deleteDisposeObjByObjids(objids);
    }

    /**
     * 删除处置对象信息
     *
     * @param objid 处置对象主键
     * @return 结果
     */
    @Override
    public int deleteDisposeObjByObjid(Long objid)
    {
        return disposeObjMapper.deleteDisposeObjByObjid(objid);
    }
}