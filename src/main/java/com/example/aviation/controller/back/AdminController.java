package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.entity.*;
import com.example.aviation.service.AdminService;
import com.example.aviation.utils.ApplicationParams;
import com.example.aviation.utils.GetIP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/11 星期二 16:24
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {
    @Resource
    private AdminService adminService;

    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    /**
     * 管理员登录
     * @param
     * @return
     */
    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        Admin admin = new Admin();
        admin.setAdminPassword(password);
        admin.setAdminPhone(username);
        LOGGER.info(GetIP.getRealIp(request) +" "+"访问了login");
        return JSON.toJSONString(adminService.queryAdminByPhoneAndPassword(admin));
    }

    /**
     * 初始化显示网站的状态
     * @return
     */
    @PostMapping("/initWeb")
    public String initWeb(){
        LOGGER.info("访问了initWeb");
        return JSON.toJSONString(adminService.initWeb());
    }

    /**
     * 修改网站状态
     * @return
     */
    @PostMapping("/updateWeb")
    public String updateWeb(@RequestBody Webseting webseting){
        LOGGER.info("访问了updateWeb");
        return JSON.toJSONString(adminService.updateWeb(webseting));
    }

    /**
     * 初始化短信key
     * @return
     */
    @PostMapping("/initKey")
    public String initKey(){
        LOGGER.info("访问了initKey");
        return JSON.toJSONString(ApplicationParams.note);
    }

    /**
     * 修改短信key
     * @return
     */
    @PostMapping("/updateKey")
    public String updateKey(@RequestBody Note note){
        LOGGER.info("访问了updateKey");
        return JSON.toJSONString(adminService.updateKey(note));
    }


    /**
     * 初始化短信smtp
     * @return
     */
    @PostMapping("/initSmtp")
    public String initSmtp(){
        LOGGER.info("访问了initSmtp");
        return JSON.toJSONString(ApplicationParams.emailSmtpSetting);
    }

    /**
     * 修改短信Smtp
     * @return
     */
    @PostMapping("/updateSmtp")
    public String updateSmtp(@RequestBody EmailSmtpSetting emailSmtpSetting){
        LOGGER.info("访问了updateSmtp");
        return JSON.toJSONString(adminService.updateSmtp(emailSmtpSetting));
    }


    /**
     * 初始化公司简介
     * @return
     */
    @PostMapping("/initAboutus")
    public String initAboutus(){
        LOGGER.info("访问了initAboutus");
        return JSON.toJSONString(adminService.initAboutus());
    }

    /**
     * 初始化服务内容
     * @return
     */
    @PostMapping("/initService")
    public String initService(){
        LOGGER.info("访问了initService");
        return JSON.toJSONString(adminService.initService());
    }

    /**
     * 修改公司简介
     * @return
     */
    @PostMapping("/updateAboutus")
    public String updateAboutus(@RequestBody Aboutus aboutus){
        LOGGER.info("访问了updateAboutus");
        return JSON.toJSONString(adminService.updateAboutus(aboutus));
    }


    /**
     * 修改服务协议
     * @return
     */
    @PostMapping("/updateService")
    public String updateService(@RequestBody ServiceAgreement serviceAgreement){
        LOGGER.info("访问了updateService");
        return JSON.toJSONString(adminService.updateService(serviceAgreement));
    }



    /**
     * 管理员列表
     * @param limit 每页记录数
     * @param page 当前页码号
     * @return
     */
    @RequestMapping("/showAdmin")
    public String getAdminList(@RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit,
                                 @RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
        Map<String ,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("limit",limit);
        LOGGER.info("访问了showAdmin");
        return JSON.toJSONString(adminService.getAdminList(map));
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @PostMapping("/addAdmin")
    public String addAdmin(@RequestBody Admin admin){
        LOGGER.info("访问了addAdmin");
        return JSON.toJSONString(adminService.addAdmin(admin));
    }



    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @PostMapping("/updateAdmin")
    public String updateAdmin(@RequestBody Admin admin){
        LOGGER.info("访问了updateAdmin");
        return JSON.toJSONString(adminService.updateAdmin(admin));
    }



    /**
     * 删除管理员
     * @param
     * @return
     */
    @PostMapping("/delAdmin")
    public String delAdmin(@RequestParam("adminId") Integer adminId){
        LOGGER.info("访问了delAdmin");
        return JSON.toJSONString(adminService.delAdmin(adminId));
    }

    /**
     * 时间戳
     * @return
     */
    @RequestMapping("time")
    public String time(){
        return JSON.toJSONString(System.currentTimeMillis());
    }
}
