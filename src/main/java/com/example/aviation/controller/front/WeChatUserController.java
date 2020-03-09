package com.example.aviation.controller.front;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.entity.User;
import com.example.aviation.service.UserService;
import com.example.aviation.utils.RedisUtils;
import com.example.aviation.utils.UserAgentUtil;
import cz.mallat.uasparser.UserAgentInfo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private UserAgentUtil userAgentUtil;
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
    public String login(@RequestParam("userPhone")String userPhone, @RequestParam("userPassword")String userPassword, HttpServletRequest request) throws IOException {
        User user = new User();
        user.setUserPhone(userPhone);
        user.setUserPassword(userPassword);
        String header = request.getHeader("User-Agent");
        UserAgentInfo parse = userAgentUtil.uaSparser.parse(header);
        String type = parse.getDeviceType();
        return JSON.toJSONString(userService.WeChatLogin(user,type));
    }


    /**
     * 前台判断是否登录
     *
     * @param
     * @return
     */
    @RequestMapping("/isLogin")
    public String isLogin(HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println("进来了Controller");
        System.out.println(token);
        Map<String, Object> map = new HashMap<>();
        map.put("data",redisUtils.get(token).toString());
        map.put("isToken",2001);
        return JSON.toJSONString(map);
    }
}
