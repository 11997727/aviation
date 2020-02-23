package com.example.aviation.model.vo;

import com.example.aviation.model.entity.Classify;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.model.vo
 * @Description:
 * @date 2020/2/12 星期三 22:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegulationsTrypeAndClassify {
    /**
     * 一级分类主键
     */
    private Integer regulationsTypeId;
    /**
     * 一级分类名称
     */
    private String regulationsTypeName;
    /**
     * 二级分类集合
     */
    private List<Classify>classifyList;
}
