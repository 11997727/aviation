package com.example.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Project: aviation
 * @Package com.example.aviation.model.entity
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:04
 * @version V1.0 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regulations {
    /**
    * 法规的主键
    */
    private Integer regulationsId;

    /**
    * 法规部号
    */
    private Integer regulationsPartNo;

    /**
    * 法规部号的别名
    */
    private String regulationsPartNoAlias;

    /**
    * 法规版本号
    */
    private String regulationsVersion;

    /**
    * 法规名称
    */
    private String regulationsName;

    /**
    * 客户端显示状态 1 显示   2不显示
    */
    private Integer regulationsShowStatus;

    /**
    * 法规所在七牛云的图标地址
    */
    private String regulationsIconPath;

    /**
    * 法规的pdf名称
    */
    private String regulationsPdfName;

    /**
    * 法规所在七牛云的地址
    */
    private String regulationsPdfPath;
    /**
     * pdf 在七牛云中的key
     *
     */
    private String key;
    /**
    * 法规版本说明
    */
    private String regulationsVersionExplain;

    private Date regulationsCreatetime;

    private Date regulationsUpdatetime;

    /**
    * 小分类的外键
    */
    private Integer classifyForeignKey;
}