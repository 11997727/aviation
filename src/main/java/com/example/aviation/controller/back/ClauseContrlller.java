package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.vo.ClauseVo;
import com.example.aviation.service.ClauseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/17 星期一 00:46
 */
@RestController
@RequestMapping("/clause")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClauseContrlller {
@Resource
private ClauseService clauseService;

    /**
     * 法规列表
     * @param limit 每页记录数
     * @param page 当前页码号
     * @return
     */
    @RequestMapping("/showClause")
    public String showClause(@RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit,
                                  @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                             @RequestParam(value = "regulationsId",required = false,defaultValue = "")Integer regulationsId,
                             @RequestParam(value = "clauseAntistop",required = false,defaultValue = "")String clauseAntistop,
                             @RequestParam(value = "clauseNo",required = false,defaultValue = "")Integer clauseNo){
        Map<String ,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("limit",limit);
        map.put("regulationsId",regulationsId);
        map.put("clauseAntistop",clauseAntistop);
        map.put("clauseNo",clauseNo);
        return JSON.toJSONString(clauseService.selectClauseList(map));
    }

    /**
     * 根据条款的id删除条款
     * @param clauseId
     * @return
     */
    @RequestMapping("/delClause")
    public String delClause(@RequestParam("clauseId") Integer clauseId){
        return JSON.toJSONString(clauseService.delClause(clauseId));
    }

    /**
     * 添加条款
     * @param clauseVo
     * @return
     */
    @RequestMapping("/addClause")
    public String addClause(@RequestBody ClauseVo clauseVo){
     return JSON.toJSONString(clauseService.addClause(clauseVo));
    }

    /**
     * 查询条款根据主键
     * @param clauseId
     * @return
     */
    @RequestMapping("/queryClauseByClauseId")
    public String queryClauseByClauseId(@RequestParam("clauseId") Integer clauseId){
        return JSON.toJSONString(clauseService.queryClauseByClauseId(clauseId));
    }



    /**
     * 修改条款根据主键
     * @param
     * @return
     */
    @RequestMapping("/updateClause")
    public String updateClauseByClauseId(@RequestBody ClauseVo clauseVo){
        return JSON.toJSONString(clauseService.updateClauseByClauseId(clauseVo));
    }
}
