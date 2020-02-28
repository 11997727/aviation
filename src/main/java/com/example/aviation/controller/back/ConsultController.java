package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.service.ConsultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/18 星期二 00:31
 */
@RestController
@RequestMapping("/consult")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConsultController {
    @Resource
    private ConsultService consultService;
    private static Logger LOGGER = LoggerFactory.getLogger(ConsultController.class);
    /**
     * 咨询列表
     * @param limit 每页记录数
     * @param page 当前页码号
     * @return
     */
    @RequestMapping("/getConsultList")
    public String getConsultList(@RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit,
                               @RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
        Map<String ,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("limit",limit);
        LOGGER.info("访问了getConsultList");
        return JSON.toJSONString(consultService.queryConsultList(map));
    }

    /**
     * 删除咨询根据id
     * @param consultId
     * @return
     */
    @RequestMapping("/delConsult")
    public String delConsult(@RequestParam("consultId")Integer consultId){
        LOGGER.info("访问了delConsult");
        return JSON.toJSONString(consultService.delConsult(consultId));
    }
}
