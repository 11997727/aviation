package com.example.aviation.mapper;

import com.example.aviation.model.entity.RegulationsTrype;
import com.example.aviation.model.vo.RegulationsTrypeAndClassify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Project: aviation
 * @Package com.example.aviation.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:04
 * @version V1.0
 *
 */
public interface RegulationsTrypeMapper {
    /**
     * 查询一级分类列表 包含二级
     * @param
     * @return
     */
    List<RegulationsTrypeAndClassify>selectAll();

    /**
     * 添加一级分类
     * @param regulationsTypeName
     * @return
     */
    Integer insertOneType(@Param("regulationsTypeName") String regulationsTypeName);

    /**
     * 查询所有的一级分类
     * @return
     */
    List<RegulationsTrype>selectAllOneType();

    /**
     * 删除 一级分类
     * @param regulationsTypeId
     * @return
     */
    Integer delregulationsTrype(Integer regulationsTypeId);
}