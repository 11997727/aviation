package com.example.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.model.entity
 * @Description:
 * @date 2020/2/11 星期二 22:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Classify {
    private Integer cid;
    private String cname;
    private Integer ck;
}
