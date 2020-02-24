package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.service.RegulationsTrypeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/12 星期三 23:54
 */
@RestController
@RequestMapping("/regulationsTrype")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegulationsTrypeController {
    @Resource
    private RegulationsTrypeService regulationsTrypeService;

    /**
     * 一级分类列表 包含二级
     * @return
     */
    @RequestMapping("/regulationsTrypeList")
    public String selectRegulationsTrypeList(){
        return JSON.toJSONString(regulationsTrypeService.selectRegulationsTypeAndClassify());
    }

    /**
     * 添加一级分类
     * @param regulationsTypeName
     * @return
     */
    @RequestMapping("/addOneType")
    public String addOneType(@RequestParam("regulationsTypeName") String regulationsTypeName ) throws Exception {
            return JSON.toJSONString(regulationsTrypeService.addOneType(regulationsTypeName));
    }

    /**
     * 下拉框一级分类
     * @return
     */
    @RequestMapping("/showAllOneType")
    public String showAllOneType(){
        return JSON.toJSONString(regulationsTrypeService.queryAllOneType());
    }



    /**
     * 删除分类
     * @return
     */
    @RequestMapping("/delregulationsTrype")
    public String delregulationsTrype(@RequestParam("regulationsTypeId")Integer regulationsTypeId){
        System.out.println(regulationsTypeId);
        return JSON.toJSONString(regulationsTrypeService.delregulationsTrype(regulationsTypeId));
    }
}
