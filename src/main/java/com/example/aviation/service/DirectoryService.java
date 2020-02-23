package com.example.aviation.service;

import com.example.aviation.model.entity.Directory;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/15 星期六 01:37
 */
public interface DirectoryService {
    /**
     * 返回当前法规的目录的树形结构
     * @param regulationsId
     * @return
     */
    Map<String,Object> selectTree(Integer regulationsId);

    /**
     * 给法规添加顶级目录
     * @param directory
     * @return
     */
    Map<String, Object> addOneDirectoryById(Directory directory);
    /**
     * 给法规添加子目录
     * @param directory
     * @return
     */
    Map<String, Object> addZiDirectory(Directory directory);

    /**
     * 删除目录
     * @param directory
     * @return
     */
    Map<String,Object> delDirectory(Directory directory) throws Exception;

    /**
     * 修改目录的名称同级排序
     * @param directory
     * @return
     * @throws Exception
     */
    Map<String, Object> updateDirectoryById(Directory directory)throws Exception;

    /**
     * 微信端 显示某部法规的目录
     * @param regulationsId
     * @return
     */
    Map<String, Object> selectTree2(Integer regulationsId);

    /**
     * 根据目录id查询条款列表
     * @param directoryForeignKey
     * @return
     */
    Map<String, Object> selectClauseBydirectoryForeignKey(Integer directoryForeignKey);
}
