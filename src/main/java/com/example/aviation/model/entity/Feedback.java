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
public class Feedback {
    /**
    * 意见反馈表主键
    */
    private Integer feedbackId;

    private String feedbackContent;

    /**
    * 用户外键
    */
    private Integer userForeignKey;

    /**
    * 反馈时间
    */
    private Date feedbackCreatetime;

    /**
    * 1正常  2删除
    */
    private Integer feedbackDeleteStatus;
}