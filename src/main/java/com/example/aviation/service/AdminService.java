package com.example.aviation.service;

import com.example.aviation.model.entity.*;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/11 星期二 16:20
 */
public interface AdminService {
    /**
     * 管理登录
     * @param admin
     * @return
     */
    Map<String,Object> queryAdminByPhoneAndPassword(Admin admin);

    /**
     * 网站初始化
     * @return
     */
    Map<String,Object> initWeb();

    /**
     * 修改网站的信息状态等
     * @param webseting
     * @return
     */
    Map<String,Object> updateWeb(Webseting webseting);

    /**
     * 初始化短信key
     * @return
     */
    Map<String,Object> initKey();

    /**
     * 修改短信key
     * @param note
     * @return
     */
    Map<String,Object> updateKey(Note note);

    /**
     * 初始化短信smtp
     * @return
     */
    Map<String,Object> initSmtp();

    /**
     * 修改Smtp
     * @param emailSmtpSetting
     * @return
     */
    Map<String,Object>  updateSmtp(EmailSmtpSetting emailSmtpSetting);

    /**
     * 初始化公司简介
     * @return
     */
    Map<String,Object> initAboutus();

    /**
     * 初始化服务协议
     * @return
     */
    Map<String,Object> initService();

    /**
     *修改公司简介
     * @param aboutus
     * @return
     */
    Map<String,Object> updateAboutus(Aboutus aboutus);

    /**
     * 修改服务协议
     * @param serviceAgreement
     * @return
     */
    Map<String,Object> updateService(ServiceAgreement serviceAgreement);

    /**
     * 管理员列表
     * @param map
     * @return
     */
    Map<String,Object> getAdminList(Map<String, Object> map);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    Map<String,Object> addAdmin(Admin admin);

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    Map<String,Object> updateAdmin(Admin admin);

    /**
     * 删除
     * @param adminId
     * @return
     */
    Map<String,Object> delAdmin(Integer adminId);
}
