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
 * @date 2020/2/17 星期一 01:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClauseVo {
    /**
     * 条款主键
     */
    private Integer clauseId;

    /**
     * 条款所在目录的外键
     */
    private Integer directoryForeignKey;
    /**
     * 法规主键
     */
    private Integer regulationsId;
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
    /**
     * 法规名称
     */
    private String regulationsName;
}
