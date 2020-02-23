package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.entity.User;
import com.example.aviation.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/17 星期一 23:29
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户列表
     * @param limit 每页记录数
     * @param page 当前页码号
     * @return
     */
    @RequestMapping("/getUsersList")
    public String getUsersList(@RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit,
                             @RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
        Map<String ,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("limit",limit);
        return JSON.toJSONString(userService.queryUserList(map));
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        return JSON.toJSONString(userService.updateUser(user));
    }
}
