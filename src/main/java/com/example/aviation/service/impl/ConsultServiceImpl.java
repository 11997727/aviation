package com.example.aviation.service.impl;

import com.example.aviation.mapper.ConsultMapper;
import com.example.aviation.model.vo.ConsultVo;
import com.example.aviation.service.ConsultService;
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
 * @date 2020/2/18 星期二 00:34
 */
@Service
public class ConsultServiceImpl implements ConsultService {
    @Resource
    private ConsultMapper consultMapper;
    @Override
    public Map<String, Object> queryConsultList(Map<String, Object> map) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("count",0);
        resultMap.put("code",2004);
        int page=Integer.parseInt(map.get("page").toString());
        int limit=Integer.parseInt(map.get("limit").toString());
        int index=(page-1)*limit;
        map.put("index",index);
        List<ConsultVo> list = consultMapper.selectConsultList(map);
        Long num = consultMapper.selectConsultListCount(map);
        if(num>0){
            resultMap.put("code",2001);
            resultMap.put("data",list);
            resultMap.put("count",num);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> delConsult(Integer consultId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer=  consultMapper.delConsult(consultId);
        if(integer>0){
          resultMap.put("msg","success");
          resultMap.put("code",2001);
      }
        return resultMap;
    }
}
