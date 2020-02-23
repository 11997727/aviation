package com.example.aviation.service;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/13 星期四 02:00
 */
public interface ClassifyService {
    /**
     * 通过一级分类查询二级分类列表
     * @param regulationsTypeId
     * @return
     */
    Map<String,Object>queryClassifyByRegulationsTypeId(Integer regulationsTypeId);

    /**
     * 根据cid 修改二级分类得名称
     * @param cname
     * @param cid
     * @return
     */
    Map<String,Object>updateClassifyNameByCid( String cname,Integer cid);

    /**
     * 删除分类包含法规
     * @param cid
     * @return
     */
    Map<String,Object> delClassifyByCid(Integer cid);

    /**
     * 添加二级分类
     * @param cname
     * @param ck
     * @return
     */
    Map<String,Object> addCassify(String cname, Integer ck);

    /**
     * 根据cid 查询 ck相同的分类
     * @param cid
     * @return
     */
    Map<String,Object>  selectCassifyByCid(Integer cid);
}
