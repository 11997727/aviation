package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.service.RegulationsTrypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger LOGGER = LoggerFactory.getLogger(RegulationsTrypeController.class);
    /**
     * 一级分类列表 包含二级
     * @return
     */
    @RequestMapping("/regulationsTrypeList")
    public String selectRegulationsTrypeList(){
        LOGGER.info("访问了regulationsTrypeList");
        return JSON.toJSONString(regulationsTrypeService.selectRegulationsTypeAndClassify());
    }

    /**
     * 添加一级分类
     * @param regulationsTypeName
     * @return
     */
    @RequestMapping("/addOneType")
    public String addOneType(@RequestParam("regulationsTypeName") String regulationsTypeName ) throws Exception {
        LOGGER.info("访问了addOneType");
            return JSON.toJSONString(regulationsTrypeService.addOneType(regulationsTypeName));
    }

    /**
     * 下拉框一级分类
     * @return
     */
    @RequestMapping("/showAllOneType")
    public String showAllOneType(){
        LOGGER.info("访问了showAllOneType");
        return JSON.toJSONString(regulationsTrypeService.queryAllOneType());
    }



    /**
     * 删除分类
     * @return
     */
    @RequestMapping("/delregulationsTrype")
    public String delregulationsTrype(@RequestParam("regulationsTypeId")Integer regulationsTypeId){
        LOGGER.info("访问了delregulationsTrype");
        return JSON.toJSONString(regulationsTrypeService.delregulationsTrype(regulationsTypeId));
    }
}
