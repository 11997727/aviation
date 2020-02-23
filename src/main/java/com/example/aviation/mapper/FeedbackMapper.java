package com.example.aviation.mapper;

import com.example.aviation.model.entity.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Project: aviation
 * @Package com.example.aviation.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/2/11 星期二 16:03
 * @version V1.0 
 *
 */
public interface FeedbackMapper {
    /**
     * 反馈列表
     * @param map
     * @return
     */
    List<Feedback> selectFeedbackList(@Param("map") Map<String, Object> map);

    /**
     * 反馈列表数量
     * @param map
     * @return
     */
    Long selectFeedbackListCount(@Param("map")Map<String, Object> map);

    /**
     * 删除反馈
     * @param feedbackId
     * @return
     */
    Integer delFeedbackByFeedbackId(@Param("feedbackId") Integer feedbackId);

    /**
     * 查询反馈通过id
     * @param feedbackId
     * @return
     */
    Feedback queryFeedbackByFeedbackId(@Param("feedbackId")Integer feedbackId);
}