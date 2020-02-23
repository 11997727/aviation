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
public class EmailSmtpSetting {
    /**
    * 邮箱smtp设置表主键
    */
    private Integer smtpId;

    /**
    * 邮箱
    */
    private String smtpEmail;

    /**
    * 服务器
    */
    private String smtpServer;

    private String smtpUsername;

    private String smtpPassword;

    /**
    * 发送次数
    */
    private Integer number;

    /**
    * 登录类型
    */
    private Integer loginType;
}