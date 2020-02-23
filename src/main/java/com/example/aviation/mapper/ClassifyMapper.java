package com.example.aviation.mapper;

import com.example.aviation.model.entity.Classify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Project: aviation
 * @Package com.example.aviation.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:03
 * @version V1.0 
 *
 */
public interface ClassifyMapper {

    /**根据一级分类查询二级分类 下拉框
     * 根据一级分类查询二级分类列表
     * @param regulationsTypeId
     * @return
     */
    List<Classify>selectClassifyByRegulationsTypeId(@Param("regulationsTypeId") Integer regulationsTypeId);

    /**
     * 根据二级分类得id  修改名称
     * @param cname
     * @param cid
     * @return
     */
    Integer updateClassifyByCid(@Param("cname") String cname,@Param("cid")Integer cid);

    /**
     * 删除分类根据id
     * @param cid
     * @return
     */
    Integer delClassifyByCid(Integer cid);

    /**
     * 添加二级分类
     * @param cname
     * @param ck
     * @return
     */
    Integer addCassify(@Param("cname") String cname,@Param("ck") Integer ck);

    /**
     * 根据cid  返回ck值一样的集合
     * @param cid
     * @return
     */
    List<Classify> selectCassifyByCid(@Param("cid") Integer cid);

    /**
     * 查询二级分类的主键
     * @param regulationsTypeId
     * @return
     */
    List<Integer> selectCassifyByCk(@Param("regulationsTypeId") Integer regulationsTypeId);

    /**
     * 删除二级分类
     * @param list
     * @return
     */
    Integer delClassifyByCidList(@Param("list") List<Integer> list);
}