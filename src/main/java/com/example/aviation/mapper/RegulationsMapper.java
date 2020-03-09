package com.example.aviation.mapper;

import com.example.aviation.model.dto.RegulationsDto;
import com.example.aviation.model.entity.Regulations;
//import com.example.aviation.model.vo.RegulationsAndTypeAndClassify;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Project: aviation
 * @Package com.example.aviation.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:04
 * @version V1.0 
 *
 */
public interface RegulationsMapper {
    /**
     * 法规列表
     * @param map
     * @return
     */
    List<Regulations>selectList(@Param("map") Map<String,Object>map);

    /**
     *法规列表 数量
     * @return
     */
    Long selectListCount(@Param("map") Map<String,Object>map);

    /**
     * 删除法规
     * @param regulationsId
     * @return
     */
    Integer delRegulationsById(@Param("regulationsId") Integer regulationsId);

    /**
     * 添加法规
     * @param regulationsDto
     * @return
     */
    Integer addRegulations(RegulationsDto regulationsDto);
    /**
     * 修改法规
     * @param regulationsDto
     * @return
     */
    Integer updateRegulations(RegulationsDto regulationsDto);

    /**
     * 查询一部法规
     * @param regulationsId
     * @return
     */
    Regulations selectRegulationsByRegulationsId(@Param("regulationsId") Integer regulationsId);

    /**
     * 查询某二级分类下的法规名称和主键
     * @return
     */
    List<Regulations> selectRegulationsNameAndId(@Param("cid")Integer cid);

    /**
     * 查询所有法规的名称和主键
     * @return
     */
    List<Regulations> selectAllRegulationsNameAndId();

    /**
     * 微信首页
     * @return
     */
    List<Regulations> showRegulations();

    /**
     * 查询所有的法规主键
     * @param cid
     * @return
     */
    List<Integer> selectRegulationsByCid(@Param("cid") Integer cid);

    /**
     * 删除法规通过法规主键集合
     * @param list
     * @return
     */
    Integer updateRegulationsByRegulationsIdList(@Param("list") List<Integer> list);

    /**
     * 根据cid 集合查询 法规主键集合
     * @param list
     * @return
     */
    List<Integer>  selectRegulationsByCidList(@Param("list")List<Integer> list);
}