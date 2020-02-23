package com.example.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Note {
    /**
    * 短信设置表  主键
    */
    private Integer noteId;

    /**
    * 短信服务商所购买的key
    */
    private String apiKey;
}