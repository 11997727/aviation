package com.example.aviation.mapper;

import com.example.aviation.model.dto.RegulationsDirectory;
import com.example.aviation.model.dto.TreeNode;
import com.example.aviation.model.entity.Directory;
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
public interface DirectoryMapper {
    /**
     * 根据法规查询目录的主键
     * @param regulationsId
     * @return
     */
    List<Integer>selectDeprecatedIds(@Param("regulationsId") Integer regulationsId);

    /**
     *删除目录
     * @param
     * @return
     */
     Integer deleteDeprecated(@Param("regulationsId") Integer regulationsId);

    /**
     *  查询所有的目录
     * @return
     */
     List<TreeNode> selectTreeNode(@Param("regulationsId") Integer regulationsId);

    /**
     * 添加一级目录
     * @param directory
     * @return
     */
    Integer addOneDirectoryById(Directory directory);

    /**
     * 添加子目录
     * @param directory
     * @return
     */
    Integer addZiDirectory(Directory directory);

    /**
     * 通过线索查询目录的主键集合，用于修改目录下条款所在目录状态
     * @param directory
     * @return
     */
    List<Integer>selectDirectoryIdByDirectoryKey(Directory directory);

    /**
     * 删除目录包含子孙目录
     * @param list
     * @return
     */
    Integer delDirectorys(@Param("list")List<Integer>list);

    /**
     * 修改目录的信息
     * @param directory
     * @return
     */
    Integer updateDirectoryById(Directory directory);

    /**
     * 微信端显示目录
     * @param regulationsId
     * @return
     */
    List<RegulationsDirectory> selectTreeNode2(@Param("regulationsId") Integer regulationsId);

    /**
     * 根据法规的主键集合查询目录主键集合
     * @param list
     * @return
     */
    List<Integer> selectDeprecatedIdsByRegulationsList(@Param("list")List<Integer> list);
}