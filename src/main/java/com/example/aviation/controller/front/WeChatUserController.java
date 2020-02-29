package com.example.aviation.controller.front;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.entity.User;
import com.example.aviation.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@Api(tags="用户相关操作")
public class WeChatUserController {
    @Resource
    private UserService userService;


    @ApiOperation(value = "输入账号密码验证登录信息",notes = "正确返回用户信息，错误返回错误码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "电话号码",type = "String",example = "19919990911"),
            @ApiImplicitParam(name="userPassword",value = "密码",type = "String",example = "123456")
    })
    @ApiResponses({
            @ApiResponse(code = 2004,message = "failed"),
            @ApiResponse(code = 2001,message = "success")
    })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("userPhone")String userPhone,@RequestParam("userPassword")String userPassword){
        User user = new User();
        user.setUserPhone(userPhone);
        user.setUserPassword(userPassword);
        return JSON.toJSONString(userService.WeChatLogin(user));
    }
}
