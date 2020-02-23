package com.example.aviation.service;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/12 星期三 23:49
 */

public interface RegulationsTrypeService {

    /**
     * 法规类型列表 包含 分类
     * @return
     */
    Map<String,Object>selectRegulationsTypeAndClassify();

    /**
     * 添加一级分类
     * @param regulationsTypeName
     * @return
     */
    Map<String,Object>addOneType(String regulationsTypeName) throws Exception;

    /**
     * 查询一级分类
     * @return
     */
    Map<String,Object>queryAllOneType();

    /**
     * 删除一级分类
     * @param regulationsTypeId
     * @return
     */
    Map<String,Object> delregulationsTrype(Integer regulationsTypeId);
}
