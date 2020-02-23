package com.example.aviation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.model.dto
 * @Description:
 * @date 2020/2/13 星期四 20:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegulationsDto {
    /**
     * pdf文件在七牛云里的key
     */
    private String key;
    /**
     * 一级分类
     */
    private Integer regulationsTypeId;
    /**
     * 二级分类
     */
    private Integer cid;
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
     * 法规版本说明
     */
    private String regulationsVersionExplain;

    private Date regulationsCreatetime;

    private Date regulationsUpdatetime;

}
