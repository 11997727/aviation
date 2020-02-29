package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.vo.ClauseVo;
import com.example.aviation.service.ClauseService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(tags="法规目录条款相关操作")
public class ClauseContrlller {
@Resource
private ClauseService clauseService;
    private static Logger LOGGER = LoggerFactory.getLogger(ClauseContrlller.class);
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
        LOGGER.info("访问了showClause");
        return JSON.toJSONString(clauseService.selectClauseList(map));
    }

    /**
     * 根据条款的id删除条款
     * @param clauseId
     * @return
     */
    @RequestMapping("/delClause")
    public String delClause(@RequestParam("clauseId") Integer clauseId){
        LOGGER.info("访问了delClause");
        return JSON.toJSONString(clauseService.delClause(clauseId));
    }

    /**
     * 添加条款
     * @param clauseVo
     * @return
     */
    @RequestMapping("/addClause")
    public String addClause(@RequestBody ClauseVo clauseVo){
        LOGGER.info("访问了addClause");
     return JSON.toJSONString(clauseService.addClause(clauseVo));
    }

    /**
     * 查询条款根据主键
     * @param clauseId
     * @return
     */
    @ApiOperation(value = "根据条款的id查询条款详情",notes = "正确返回条款信息，错误返回错误码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clauseId",value = "条款主键",type = "Integer",example = "58"),
    })
    @ApiResponses({
            @ApiResponse(code = 2004,message = "failed"),
            @ApiResponse(code = 2001,message = "success")
    })
    @RequestMapping(value = "/queryClauseByClauseId" ,method = RequestMethod.POST)
    public String queryClauseByClauseId(@RequestParam("clauseId") Integer clauseId){
        LOGGER.info("访问了queryClauseByClauseId");
        return JSON.toJSONString(clauseService.queryClauseByClauseId(clauseId));
    }



    /**
     * 修改条款根据主键
     * @param
     * @return
     */
    @RequestMapping("/updateClause")
    public String updateClauseByClauseId(@RequestBody ClauseVo clauseVo){
        LOGGER.info("访问了updateClause");
        return JSON.toJSONString(clauseService.updateClauseByClauseId(clauseVo));
    }
}
