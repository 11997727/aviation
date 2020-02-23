package com.example.aviation.service.impl;

import com.example.aviation.mapper.UserMapper;
import com.example.aviation.model.entity.User;
import com.example.aviation.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> WeChatLogin(User user) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        User u=userMapper.WeChatLogin(user);
        if(u!=null){
            resultMap.put("code",2001);
            resultMap.put("msg","success");
            resultMap.put("data",u);
        }
        return resultMap;
    }
}
