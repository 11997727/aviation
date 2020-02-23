package com.example.aviation.service;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/18 星期二 00:31
 */
public interface ConsultService {
    /**
     * 咨询列表
     * @param map
     * @return
     */
    Map<String,Object> queryConsultList(Map<String, Object> map);

    /**
     * 删除咨询根据id
     * @param consultId
     * @return
     */
    Map<String,Object> delConsult(Integer consultId);
}
