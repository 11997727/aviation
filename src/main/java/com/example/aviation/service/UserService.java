package com.example.aviation.service;

import com.example.aviation.model.entity.User;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/17 星期一 23:31
 */
public interface UserService {
    /**
     * 查询用户列表
     * @param map
     * @return
     */
    Map<String,Object> queryUserList(Map<String, Object> map);

    /**
     * 用户修改
     * @param user
     * @return
     */
    Map<String,Object> updateUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    Map<String,Object> WeChatLogin(User user,String type);
}
