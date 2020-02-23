package com.example.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project: aviation
 * @Package com.example.aviation.model.entity
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:04
 * @version V1.0 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Webseting {
    /**
    * 网站主键
    */
    private Integer webId;

    /**
    * 1正常  2关闭
    */
    private Integer webStatus;

    /**
    * 网站标题
    */
    private String webTitle;

    /**
    * 网站域名
    */
    private String webDomainName;

    /**
    * 网站的logo地址
    */
    private String webLogoPath;

    /**
    * 公司邮箱
    */
    private String webEmail;

    /**
    * 站点语言2英语   1中文
    */
    private Integer language;
}