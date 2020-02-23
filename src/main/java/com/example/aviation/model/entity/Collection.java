package com.example.aviation.model.entity;

import java.util.Date;
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
public class Collection {
    /**
    * 收藏表的主键
    */
    private Integer collectionId;

    /**
    * 用户外键
    */
    private Integer userForeignKey;

    /**
    * 条款外键
    */
    private Integer clauseForeignKey;

    /**
    * 收藏时间
    */
    private Date collectionTime;
}