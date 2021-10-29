package com.ruoyi.knowledge.service.impl;

import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.domain.PiPei;
import com.ruoyi.knowledge.mapper.PiPeiMapper;
import com.ruoyi.knowledge.service.IPiPeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//public class PiPeiServiceImpl {
//}


/**
 * 出警记录表Service业务层处理
 *
 * @author ruoyi
 * @date 2021-10-15
 */
@Service
public class PiPeiServiceImpl implements IPiPeiService
{
    @Autowired
    private PiPeiMapper pipeiMapper;


    /**
     * 查询出警记录表列表
     *
     * @param record 出警记录表
     * @return 出警记录表
     */
    @Override
    public List<PiPei> selectPiPeiList(PiPei pipei)
    {
        return pipeiMapper.selectPiPeiList(pipei);
    }

    /**
     * 新增出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    @Override
    public int insertPiPei(PiPei pipei)
    {
        return pipeiMapper.insertPiPei(pipei);
    }

    /**
     * 修改出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    @Override
    public int updatePiPei(PiPei pipei)
    {
        return pipeiMapper.updatePiPei(pipei);
    }


}
