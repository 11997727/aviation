package com.example.aviation.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.utils
 * @Description: 捕捉全局异常
 * @date 2020/2/24 星期一 18:13
 */
@ControllerAdvice
public class MyExceptionHandler {
    private Map<String,Object> map=new HashMap<>();

    private static Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);


    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public String exceptionHandler(RuntimeException e){
        System.out.println("enter1...");
        System.out.println(e);
        LOGGER.error(e.toString());
        map.put("msg","RuntimeException");
        map.put("code",4000);
        return JSON.toJSONString(map);
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public String exceptionHandler(NullPointerException e){
        System.out.println("enter2...");
        System.out.println(e);
        LOGGER.error(e.toString());
        map.put("msg","NullPointerException");
        map.put("code",4000);
        return JSON.toJSONString(map);
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public String exceptionHandler(IOException e){
        System.out.println("enter3...");
        System.out.println(e);
        LOGGER.error(e.toString());
        map.put("msg","IOException");
        map.put("code",4000);
        return JSON.toJSONString(map);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e){
        System.out.println("enter4...");
        System.out.println(e);
        LOGGER.error(e.toString());
        map.put("msg","Exception");
        map.put("code",4000);
        return JSON.toJSONString(map);
    }
}
