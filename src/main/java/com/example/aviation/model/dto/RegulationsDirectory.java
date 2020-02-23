package com.example.aviation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.model.dto
 * @Description:  小程序法规的目录
 * @date 2020/2/20 星期四 22:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegulationsDirectory {
    /**
     * 目录 id
     */
    private Integer id;
    /**
     * 父id
     */
    private Integer pid;
    /**
     * 目录名称
     */
    private String title;
    /**
     * 当前目录的子目录
     */
    private List<RegulationsDirectory>children;

    public static List<RegulationsDirectory> listGetStree(List<RegulationsDirectory> list) {
        List<RegulationsDirectory> treeList = new ArrayList<RegulationsDirectory>();
        for (RegulationsDirectory tree : list) {
            //找到根
            if (tree.getPid() == 0) {
                treeList.add(tree);
            }
            //找到子
            for (RegulationsDirectory treeNode : list) {
                if (treeNode.getPid().equals(tree.getId())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<RegulationsDirectory>());
                    }
                    tree.getChildren().add(treeNode);
                }
            }
        }
        return treeList;
    }
}
