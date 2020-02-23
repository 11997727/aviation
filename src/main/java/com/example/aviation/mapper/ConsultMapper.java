package com.example.aviation.mapper;

import com.example.aviation.model.vo.ConsultVo;
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
public interface ConsultMapper {
    /**
     * 查询咨询表
     * @param map
     * @return
     */
    List<ConsultVo> selectConsultList(@Param("map") Map<String, Object> map);

    /**
     * 查询咨询表数量
     * @param map
     * @return
     */
    Long selectConsultListCount(@Param("map") Map<String, Object> map);

    /**
     * 修改删除状态
     * @param consultId
     * @return
     */
    Integer delConsult(Integer consultId);
}