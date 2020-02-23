package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.service.FeedbackService;
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
 * @date 2020/2/23 星期日 11:24
 */
@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    /**
     * 反馈列表
     * @param limit 每页记录数
     * @param page 当前页码号
     * @return
     */
    @RequestMapping("/feedbackList")
    public String showClause(@RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit,
                             @RequestParam(value = "page",required = false,defaultValue = "1") Integer page
                            ){
        Map<String ,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("limit",limit);
        return JSON.toJSONString(feedbackService.selectFeedbackList(map));
    }

    /**
     * 删除反馈通过id
     * @param feedbackId
     * @return
     */
    @RequestMapping("/delFeedback")
    public String delFeedback(@RequestParam("feedbackId")Integer feedbackId){
        return JSON.toJSONString(feedbackService.delFeedbackByFeedbackId(feedbackId));
    }


    /**
     * 查询反馈通过id
     * @param feedbackId
     * @return
     */
    @RequestMapping("/queryFeedbackByFeedbackId")
    public String queryFeedbackByFeedbackId(@RequestParam("feedbackId")Integer feedbackId){
        return JSON.toJSONString(feedbackService.queryFeedbackByFeedbackId(feedbackId));
    }
}
