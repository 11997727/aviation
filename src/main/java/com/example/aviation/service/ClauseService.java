package com.example.aviation.service;

import com.example.aviation.model.vo.ClauseVo;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/17 星期一 01:21
 */
public interface ClauseService {
    /**
     * 条款列表
     * @param map
     * @return
     */
    Map<String,Object>selectClauseList(Map<String,Object>map);

    /**
     * 删除条款
     * @param clauseId
     * @return
     */
    Map<String,Object> delClause(Integer clauseId);

    /**
     * 添加条款
     * @param clauseVo
     * @return
     */
    Map<String,Object> addClause(ClauseVo clauseVo);

    /**
     * 查询条款根据主键
     * @param clauseId
     * @return
     */
    Map<String,Object> queryClauseByClauseId(Integer clauseId);

    /**
     * 修改条款
     * @param clauseVo
     * @return
     */
    Map<String,Object> updateClauseByClauseId(ClauseVo clauseVo);
}
