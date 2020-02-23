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
public class Admin {
    /**
    * 管理员主键
    */
    private Integer adminId;

    /**
    * 管理员电话
    */
    private String adminPhone;

    /**
    * 管理员姓名
    */
    private String adminName;

    private Date adminCreatetime;

    /**
    * 正常1   删除2
    */
    private Integer adminDeleteStatus;

    /**
    * 管理员登录密码
    */
    private String adminPassword;

    /**
    * 1普通   2超级
    */
    private Integer adminType;
}