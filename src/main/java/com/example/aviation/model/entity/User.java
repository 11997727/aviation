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
public class User {
    /**
    * 用户主键
    */
    private Integer userId;

    /**
    * 用户姓名
    */
    private String userName;

    /**
    * 用户电话
    */
    private String userPhone;

    /**
    * 性别  1男  2女
    */
    private Integer userSex;

    /**
    * 会员类型1免费   2付费
    */
    private Integer userType;

    /**
    * 用户创建日期
    */
    private Date userCreatetime;

    /**
    * 1正常    2删除
    */
    private Integer userDeleteStatus;

    /**
    * 用户最后修改信息的时间
    */
    private Date userUpdatetime;

    /**
    * 登录密码
    */
    private String userPassword;
}