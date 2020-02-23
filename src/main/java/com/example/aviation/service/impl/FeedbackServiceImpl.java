package com.example.aviation.service.impl;

import com.example.aviation.mapper.FeedbackMapper;
import com.example.aviation.model.entity.Feedback;
import com.example.aviation.service.FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service.impl
 * @Description:
 * @date 2020/2/23 星期日 11:28
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;
    @Override
    public Map<String, Object> selectFeedbackList(Map<String, Object> map) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("count",0);
        resultMap.put("code",2004);
        int page=Integer.parseInt(map.get("page").toString());
        int limit=Integer.parseInt(map.get("limit").toString());
        int index=(page-1)*limit;
        map.put("index",index);
        List<Feedback> list = feedbackMapper.selectFeedbackList(map);
        Long num = feedbackMapper.selectFeedbackListCount(map);
        if(num>0){
            resultMap.put("code",2001);
            resultMap.put("data",list);
            resultMap.put("count",num);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> delFeedbackByFeedbackId(Integer feedbackId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer=  feedbackMapper.delFeedbackByFeedbackId(feedbackId);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryFeedbackByFeedbackId(Integer feedbackId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Feedback feedback=  feedbackMapper.queryFeedbackByFeedbackId(feedbackId);
        if(feedback!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",feedback);
        }
        return resultMap;
    }
}
