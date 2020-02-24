package com.example.aviation.service;

import com.example.aviation.model.dto.RegulationsDto;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/11 星期二 21:20
 */
public interface RegulationsService {
    /**
     * 后台管理查看法规列表
     * @param map
     * @return
     */
    Map<String,Object>selectRegulationsListVo(Map<String,Object>map);

    /**
     * 删除法规
     * @param regulationsId
     * @return
     */
    Map<String,Object>delRegulations(Integer regulationsId) throws Exception;

    /**
     * 添加法规
     * @param regulationsDto
     * @return
     * @throws Exception
     */
    Map<String,Object>addRegulations(RegulationsDto regulationsDto) throws Exception;

    /**
     * 查询某个法规
     * @param regulationsId
     * @return
     */
    Map<String,Object> selectRegulationsByRegulationsId(Integer regulationsId);

    /**
     * 修改法规
     * @param regulationsDto
     * @return
     * @throws Exception
     */
    Map<String,Object>updateRegulations(RegulationsDto regulationsDto) throws Exception;

    /**
     * 查询某二级分类下的法规名称和主键
     * @return
     */
    Map<String,Object> showRegulationsNameAndId(Integer cid);

    /**
     * 查询所有法规的名称和主键
     * @return
     */
    Map<String,Object> showAllRegulationsNameAndId();

    /**
     * 微信首页显示默认9个法规
     * @return
     */
    Map<String,Object> showRegulations();
}
