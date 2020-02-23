package com.example.aviation.mapper;

import com.example.aviation.model.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Project: aviation
 * @Package com.example.aviation.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:04
 * @version V1.0 
 *
 */
public interface UserMapper {
    /**
     * 用户列表
     * @param map
     * @return
     */
    List<User> selectUserList(@Param("map") Map<String, Object> map);

    /**
     * 用户列表数量
     * @param map
     * @return
     */
    Long selectUserListCount(@Param("map") Map<String, Object> map);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 微信用户登录
     * @param user
     * @return
     */
    User WeChatLogin(User user);
}