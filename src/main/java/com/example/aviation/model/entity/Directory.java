package com.example.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project: aviation
 * @Package com.example.aviation.model.entity
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:03
 * @version V1.0 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Directory {
    /**
    * 目录的主键
    */
    private Integer directoryId;

    /**
    * 目录名称
    */
    private String directoryNama;

    /**
    * 父级目录的id
    */
    private Integer parentId;

    /**
    * 目录线索 比如顶级目录那么线索是- 那么它的父级id就是0
    */
    private String directoryKey;

    /**
    * 表示当前节点到根节点的距离 如果是顶级目录那么距离就是1
    */
    private Integer distance;

    /**
    * 同级别目录的顺序，值越大越靠前
    */
    private Integer level;

    /**
    * 法规的外键
    */
    private Integer regulationsForeignKey;

    /**
    * 目录的显示状态: 如果法规的显示状态是2 那么当前法规对应的目录显示状态是2
    */
    private Integer distanceShowStatus;
}