package com.example.aviation.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.aviation.mapper.UserMapper;
import com.example.aviation.model.entity.User;
import com.example.aviation.service.UserService;
import com.example.aviation.utils.MD5;
import com.example.aviation.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service.impl
 * @Description:
 * @date 2020/2/17 星期一 23:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisUtils redisUtils;
    @Override
    public Map<String, Object> queryUserList(Map<String, Object> map) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("count",0);
        resultMap.put("code",2004);
        int page=Integer.parseInt(map.get("page").toString());
        int limit=Integer.parseInt(map.get("limit").toString());
        int index=(page-1)*limit;
        map.put("index",index);
        List<User> list = userMapper.selectUserList(map);
        Long num = userMapper.selectUserListCount(map);
        if(num>0){
            resultMap.put("code",2001);
            resultMap.put("data",list);
            resultMap.put("count",num);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateUser(User user) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer=userMapper.updateUser(user);
        if(integer>0){
            resultMap.put("code",2001);
            resultMap.put("msg","success");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> WeChatLogin(User user,String type) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        User u=userMapper.WeChatLogin(user);
        if(u!=null){
            System.out.println("登录成功");
            resultMap.put("code",2001);
            resultMap.put("msg","success");
            resultMap.put("data",u);
            String token = this.createToken(u, type);
            resultMap.put("token",token);
            this.saveToken(u,token);
        }
        return resultMap;
    }
    //存放token
    private void saveToken(User user1, String token) {
        String tokenKey="User"+user1.getUserId();
        String tokenValue=null;
        if((tokenValue=(String) redisUtils.get(tokenKey))!=null){ //单点登录
            redisUtils.delete(tokenKey);
            redisUtils.delete(tokenValue);
        }
        redisUtils.set(tokenKey,token,3600000);//token 设置1小时
        redisUtils.set(token, JSON.toJSONString(user1),3600000);
    }
    //创建token
    private String createToken(User user, String type) {
        StringBuilder sb=new StringBuilder();
        sb.append("token-");
        sb.append(type);
        sb.append(MD5.getMD5(user.getUserId().toString(),32));
        sb.append(LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        sb.append(UUID.randomUUID().toString().substring(0,6));
        return sb.toString();
    }
}
