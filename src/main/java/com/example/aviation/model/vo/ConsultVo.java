package com.example.aviation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.model.vo
 * @Description:
 * @date 2020/2/18 星期二 00:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultVo {
    /**
     * 咨询表主键
     */
    private Integer consultId;

    /**
     * 用户外键
     */
    private Integer userForeignKey;

    /**
     * 条款外键
     */
    private Integer clauseForeignKey;
    /**
     * 显示相关的条款
     */
    private Integer clauseNo;

    /**
     * 咨询内容
     */
    private String consultContent;

    /**
     * 1正常   2删除
     */
    private Integer consultDeleteStatus;

    /**
     * 咨询时间
     */
    private Date consultCreatetime;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户电话
     */
    private String userPhone;
}
