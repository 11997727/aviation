package com.example.aviation.service.impl;

import com.example.aviation.mapper.AdminMapper;
import com.example.aviation.model.entity.*;
import com.example.aviation.service.AdminService;
import com.example.aviation.utils.ApplicationParams;
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
 * @date 2020/2/11 星期二 16:26
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public Map<String, Object> queryAdminByPhoneAndPassword(Admin admin) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Admin admin1 = adminMapper.selectAdminByPhoneAndPassword(admin);
        if(admin1!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",admin1);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> initWeb() {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Webseting webseting = adminMapper.initWeb();
        if(webseting!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",webseting);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateWeb(Webseting webseting) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer = adminMapper.updateWeb(webseting);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> initKey() {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Note note = adminMapper.initKey();
        if(note!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",note);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateKey(Note note) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer = adminMapper.updateKey(note);
        if(integer>0){
            ApplicationParams.note=note;
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> initSmtp() {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        EmailSmtpSetting emailSmtpSetting = adminMapper.initSmtp();
        if(emailSmtpSetting!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",emailSmtpSetting);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateSmtp(EmailSmtpSetting emailSmtpSetting) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer = adminMapper.updateSmtp(emailSmtpSetting);
        if(integer>0){
            ApplicationParams.emailSmtpSetting=emailSmtpSetting;
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> initAboutus() {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Aboutus aboutus = adminMapper.initAboutus();
        if(aboutus!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",aboutus);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> initService() {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        ServiceAgreement serviceAgreement = adminMapper.initService();
        if(serviceAgreement!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",serviceAgreement);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateAboutus(Aboutus aboutus) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer = adminMapper.updateAboutus(aboutus);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateService(ServiceAgreement serviceAgreement) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer = adminMapper.updateService(serviceAgreement);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getAdminList(Map<String, Object> map) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("count",0);
        resultMap.put("code",2004);
        int page=Integer.parseInt(map.get("page").toString());
        int limit=Integer.parseInt(map.get("limit").toString());
        int index=(page-1)*limit;
        map.put("index",index);
        List<Admin> list = adminMapper.selectAdminList(map);
        Long num = adminMapper.selectAdminListCount(map);
        if(num>0){
            resultMap.put("code",2001);
            resultMap.put("data",list);
            resultMap.put("count",num);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> addAdmin(Admin admin) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Admin admin1=  adminMapper.isPhone(admin.getAdminPhone());
        if(admin1!=null){
          resultMap.put("msg","failed");
          resultMap.put("code",2002);
          return resultMap;
        }
       Integer integer= adminMapper.addAdmin(admin);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateAdmin(Admin admin) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer= adminMapper.updateAdmin(admin);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> delAdmin(Integer adminId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer= adminMapper.delAdmin(adminId);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }
}
