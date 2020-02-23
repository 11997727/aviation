package com.example.aviation.mapper;

import com.example.aviation.model.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Project: aviation
 * @Package com.example.aviation.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:03
 * @version V1.0 
 *
 */
public interface AdminMapper {
    /**
     * 管理员登录
     * @param admin
     * @return
     */
    Admin selectAdminByPhoneAndPassword(Admin admin);

    /**
     * 初始化网站信息
     * @return
     */
    Webseting initWeb();

    /**
     * 修改网站的状态
     * @return
     */
    Integer updateWeb(Webseting webseting);

    /**
     * 短信key
     * @return
     */
    Note initKey();

    /**
     * 修改短信key
     * @param note
     * @return
     */
    Integer updateKey(Note note);

    /**
     * 初始化Smtp
     * @return
     */
    EmailSmtpSetting initSmtp();

    /**
     * 修改Smtp
     * @param emailSmtpSetting
     * @return
     */
    Integer updateSmtp(EmailSmtpSetting emailSmtpSetting);

    /**
     * 初始化公司简介
     * @return
     */
    Aboutus initAboutus();

    /**
     * 初始化服务协议
     * @return
     */
    ServiceAgreement initService();

    /**
     * 修改公司简介
     * @param aboutus
     * @return
     */
    Integer updateAboutus(Aboutus aboutus);

    /**
     * 修改服务协议
     * @param serviceAgreement
     * @return
     */
    Integer updateService(ServiceAgreement serviceAgreement);

    /**
     * 管理员列表
     * @param map
     * @return
     */
    List<Admin> selectAdminList(@Param("map") Map<String, Object> map);

    /**
     * 管理员列表
     * @param map
     * @return
     */
    Long selectAdminListCount(@Param("map") Map<String, Object> map);

    /**
     * 验证电话
     * @param adminPhone
     * @return
     */
    Admin isPhone(@Param("adminPhone") String adminPhone);

    /**
     *添加管理员
     * @param admin
     * @return
     */
    Integer addAdmin(Admin admin);

    /**
     *
     * @param admin
     * @return
     */
    Integer updateAdmin(Admin admin);

    /**
     * 删除管理员
     * @param adminId
     * @return
     */
    Integer delAdmin(Integer adminId);
}