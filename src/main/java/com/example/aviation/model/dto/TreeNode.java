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
 * @Package com.example.aviation.utils
 * @Description:后台目录
 * @date 2020/2/15 星期六 00:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private Integer id;//目录主键
    private Integer pid;//父节点主键
    private Integer lever;//同级排序
    private String label;//目录名称
    private String directoryKey;//当前目录线索
    private String distance;//当前节点到根节点的距离
    private List<TreeNode> children;

    public static List<TreeNode> listGetStree(List<TreeNode> list) {
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        for (TreeNode tree : list) {
            //找到根
            if (tree.getPid() == 0) {
                treeList.add(tree);
            }
            //找到子
            for (TreeNode treeNode : list) {
                if (treeNode.getPid().equals(tree.getId())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<TreeNode>());
                    }
                    tree.getChildren().add(treeNode);
                    }
                }
            }
            return treeList;
        }

        /**
         * 方法二、
         * @param list
         * @return
         */
        public static List<TreeNode> listToTree(List<TreeNode> list) {
            //用递归找子。
            List<TreeNode> treeList = new ArrayList<TreeNode>();
            //遍历所有对象
            for (TreeNode tree : list) {
                if (tree.getPid() == 0) {//找出一级目录
                    treeList.add(findChildren(tree, list));
                }
            }
            return treeList;
        }

        public static TreeNode findChildren(TreeNode tree, List<TreeNode> list) {
            for (TreeNode node : list) {
                if (node.getPid().equals(tree.getId())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<TreeNode>());
                    }
                    tree.getChildren().add(findChildren(node, list));
                }
            }
            return tree;
        }

        /**
         *方法三
         * @param list
         * @return
         */
        public static List<TreeNode> toTree(List<TreeNode> list) {
            List<TreeNode> treeList = new ArrayList<TreeNode>();
            for (TreeNode tree : list) {
                if(tree.getPid() == 0){
                    treeList.add(tree);
                }
            }
            for (TreeNode tree : list) {
                toTreeChildren(treeList,tree);
            }
            return treeList;
        }

        private static void toTreeChildren(List<TreeNode> treeList, TreeNode tree) {
            for (TreeNode node : treeList) {
                if(tree.getPid().equals(node.getId())){
                    if(node.getChildren() == null){
                        node.setChildren(new ArrayList<TreeNode>());
                    }
                    node.getChildren().add(tree);
                }
                if(node.getChildren() != null){
                    toTreeChildren(node.getChildren(),tree);
                }
            }
        }


}
