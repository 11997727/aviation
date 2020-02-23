package com.example.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Project: aviation
 * @Package com.example.aviation.model.entity
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:03
 * @version V1.0 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clause {
    /**
    * 条款主键
    */
    private Integer clauseId;

    /**
    * 条款所在目录的外键
    */
    private Integer directoryForeignKey;

    /**
    * 条款的编号
    */
    private Integer clauseNo;

    /**
    * 条款编号别名
    */
    private String clauseNoAlias;

    /**
    * 条款版本号
    */
    private String clauseVersion;

    /**
    * 条款标题
    */
    private String clauseTitle;

    /**
    * 条款的内容
    */
    private String clauseContent;

    /**
    * 条款的关键词
    */
    private String clauseAntistop;

    /**
    * 条款的显示状态  1正常  2不显示   如果所在目录的显示状态是2  那么条款的状态就是2
    */
    private Integer clauseShowStatus;

    /**
    * 条款的创建时间
    */
    private Date clauseCreatetime;

    /**
    * 条款的修改时间
    */
    private Date clauseUpdatetime;
    /**
     * 法规外键
     */
    private Integer regulationsForeignkey;
}