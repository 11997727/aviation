package com.example.aviation.controller.front;

import com.alibaba.fastjson.JSON;
import com.example.aviation.service.DirectoryService;
import com.example.aviation.service.RegulationsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/11 星期二 21:29
 */
@RestController
@RequestMapping("/WeChatRegulations")
public class WeChatRegulationsController {
    @Resource
    private RegulationsService regulationsService;
    @Resource
    private DirectoryService directoryService;
    /**
     * 微信展示
     * @return
     */
    @PostMapping("/queryRegulations")
    public String showRegulations(){
        return JSON.toJSONString(regulationsService.showRegulations());
    }

    /**
     * 根据法规id查询该法规的目录
     * @param regulationsId
     * @return
     */
    @RequestMapping("/selectDirectoryById")
    public String selectDirectoryById(@RequestParam("regulationsId") Integer regulationsId){
        Map<String, Object> map = directoryService.selectTree2(regulationsId);
        return JSON.toJSONString(map);
    }


    /**
     * 根据目录查询条款列表
     * @param directoryForeignKey
     * @return
     */
    @RequestMapping("/selectClauseByDirectoryForeignKey")
    public String selectClauseByDirectoryForeignKey(@RequestParam("directoryForeignKey") Integer directoryForeignKey){
        Map<String, Object> map = directoryService.selectClauseBydirectoryForeignKey(directoryForeignKey);
        return JSON.toJSONString(map);
    }
}
