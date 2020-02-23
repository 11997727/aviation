package com.example.aviation.mapper;

import com.example.aviation.model.entity.Clause;
import com.example.aviation.model.vo.ClauseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Project: aviation
 * @Package com.example.aviation.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:03
 * @version V1.0 
 *
 */
public interface ClauseMapper {
    /**
     * 根据目录id主键的集合 查询条款主键的集合
     * @param integers
     * @return
     */
    List<Integer>selectClauseId(@Param("list") List<Integer> integers);

    /**
     * 根据目录id主键的集合 删除条款
     * @param integers
     * @return
     */
    Integer delClause(@Param("list")List<Integer> integers);

    /**
     * 查询条款列表
     * @param map
     * @return
     */
    List<ClauseVo> selectClauseList(@Param("map") Map<String, Object> map);

    /**
     * 条款列表总数量
     * @return
     */
    Long selectClauseListCount(@Param("map") Map<String, Object> map);

    /**
     * 根据id删除条款
     * @param clauseId
     * @return
     */
    Integer delClauseById(@Param("clauseId")Integer clauseId);

    /**
     * 添加条款
     * @param clauseVo
     * @return
     */
    Integer addClauseById(ClauseVo clauseVo);

    /**
     * 查询条款根据主键
     * @param clauseId
     * @return
     */
    ClauseVo selectClauseByClauseId(Integer clauseId);

    /**
     * 修改条款
     * @param clauseVo
     * @return
     */
    Integer updateClauseByClauseId(ClauseVo clauseVo);

    /**
     * 根据目录查询条款列表
     * @param directoryForeignKey
     * @return
     */
    List<Clause> selectClauseBydirectoryForeignKey(@Param("directoryForeignKey") Integer directoryForeignKey);
}