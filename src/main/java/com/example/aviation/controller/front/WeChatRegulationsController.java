package com.example.aviation.controller.front;

import com.alibaba.fastjson.JSON;
import com.example.aviation.service.DirectoryService;
import com.example.aviation.service.RegulationsService;
import io.swagger.annotations.*;
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
@Api(tags="法规目录条款相关操作")
public class WeChatRegulationsController {
    @Resource
    private RegulationsService regulationsService;
    @Resource
    private DirectoryService directoryService;
    /**
     * 微信展示
     * @return
     */
    @ApiOperation(value = "首页展示法规最新发布的9部法规",notes = "正确返回法规信息，错误返回错误码")
    @ApiResponses({
            @ApiResponse(code = 2004,message = "failed"),
            @ApiResponse(code = 2001,message = "success")
    })
    @PostMapping("/queryRegulations")
    public String showRegulations(){
        return JSON.toJSONString(regulationsService.showRegulations());
    }

    /**
     * 根据法规id查询该法规的目录
     * @param regulationsId
     * @return
     */
    @ApiOperation(value = "根据法规的id查询法规的目录",notes = "正确返回目录信息，错误返回错误码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regulationsId",value = "法规主键",type = "Integer",example = "98"),
    })
    @ApiResponses({
            @ApiResponse(code = 2004,message = "failed"),
            @ApiResponse(code = 2001,message = "success")
    })
    @PostMapping("/selectDirectoryById")
    public String selectDirectoryById(@RequestParam("regulationsId") Integer regulationsId){
        Map<String, Object> map = directoryService.selectTree2(regulationsId);
        return JSON.toJSONString(map);
    }


    /**
     * 根据目录查询条款列表
     * @param directoryForeignKey
     * @return
     */
    @ApiOperation(value = "根据目录的id查询该目录下的所有条款",notes = "正确返回目录信息，错误返回错误码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "directoryForeignKey",value = "目录主键",type = "Integer",example = "337"),
    })
    @ApiResponses({
            @ApiResponse(code = 2004,message = "failed"),
            @ApiResponse(code = 2001,message = "success")
    })
    @PostMapping("/selectClauseByDirectoryForeignKey")
    public String selectClauseByDirectoryForeignKey(@RequestParam("directoryForeignKey") Integer directoryForeignKey){
        Map<String, Object> map = directoryService.selectClauseBydirectoryForeignKey(directoryForeignKey);
        return JSON.toJSONString(map);
    }
}
