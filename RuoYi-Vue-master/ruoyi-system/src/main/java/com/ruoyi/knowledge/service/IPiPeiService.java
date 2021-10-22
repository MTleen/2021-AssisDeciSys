package com.ruoyi.knowledge.service;

import com.ruoyi.knowledge.domain.PiPei;

import java.util.List;
//
//public interface IPiPeiService {
//}


/**
 * 出警记录表Service接口
 *
 * @author ruoyi
 * @date 2021-10-15
 */
public interface IPiPeiService
{


    /**
     * 查询出警记录表列表
     *
     * @param record 出警记录表
     * @return 出警记录表集合
     */
    public List<PiPei> selectPiPeiList(PiPei pipei);

    /**
     * 新增出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    public int insertPiPei(PiPei pipei);

    /**
     * 修改出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    public int updatePiPei(PiPei pipei);


}

