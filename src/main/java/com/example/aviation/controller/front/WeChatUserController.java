package com.example.aviation.controller.front;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.entity.User;
import com.example.aviation.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.front
 * @Description:
 * @date 2020/2/19 星期三 20:46
 */
@RestController
@RequestMapping("/WeChatUser")
public class WeChatUserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return JSON.toJSONString(userService.WeChatLogin(user));
    }
}
