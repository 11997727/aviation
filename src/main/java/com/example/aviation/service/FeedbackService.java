package com.example.aviation.service;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.service
 * @Description:
 * @date 2020/2/23 星期日 11:27
 */

public interface FeedbackService {
    /**
     * 显示反馈列表
     * @param map
     * @return
     */
    Map<String,Object> selectFeedbackList(Map<String, Object> map);

    /**
     * 删除反馈
     * @param feedbackId
     * @return
     */
    Map<String,Object> delFeedbackByFeedbackId(Integer feedbackId);

    /**
     * 查询反馈通过id
     * @param feedbackId
     * @return
     */
    Map<String,Object> queryFeedbackByFeedbackId(Integer feedbackId);
}
