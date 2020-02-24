package com.example.aviation.utils;

import com.example.aviation.mapper.AdminMapper;
import com.example.aviation.model.entity.EmailSmtpSetting;
import com.example.aviation.model.entity.Note;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.utils
 * @Description:
 * @date 2020/2/24 星期一 16:36
 */
@Component
public class ApplicationParams {
    public static Note note;
    public static EmailSmtpSetting emailSmtpSetting;
    @Resource
    private AdminMapper adminMapper;

    @Bean
    public void init(){
        note=adminMapper.initKey();
        emailSmtpSetting=adminMapper.initSmtp();
    }
}
