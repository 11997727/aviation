package com.example.aviation.service.impl;

import com.example.aviation.mapper.ClauseMapper;
import com.example.aviation.model.vo.ClauseVo;
import com.example.aviation.service.ClauseService;
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
 * @date 2020/2/17 星期一 01:22
 */
@Service
public class ClauseServiceImpl implements ClauseService {
    @Resource
    private ClauseMapper clauseMapper;
    @Override
    public Map<String, Object> selectClauseList(Map<String, Object> map) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("count",0);
        resultMap.put("code",2004);
        int page=Integer.parseInt(map.get("page").toString());
        int limit=Integer.parseInt(map.get("limit").toString());
        int index=(page-1)*limit;
        map.put("index",index);
        List<ClauseVo> list = clauseMapper.selectClauseList(map);
        Long num = clauseMapper.selectClauseListCount(map);
        if(num>0){
            resultMap.put("code",2001);
            resultMap.put("data",list);
            resultMap.put("count",num);
        }
        resultMap.put("page",page);
        resultMap.put("limit",limit);
        return resultMap;
    }

    @Override
    public Map<String, Object> delClause(Integer clauseId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer=  clauseMapper.delClauseById(clauseId);
      if(integer>0){
          resultMap.put("msg","success");
          resultMap.put("code",2001);
      }
        return resultMap;
    }

    @Override
    public Map<String, Object> addClause(ClauseVo clauseVo) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer=  clauseMapper.addClauseById(clauseVo);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryClauseByClauseId(Integer clauseId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        ClauseVo clauseVo=  clauseMapper.selectClauseByClauseId(clauseId);
        if(clauseVo!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",clauseVo);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateClauseByClauseId(ClauseVo clauseVo) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer=clauseMapper.updateClauseByClauseId(clauseVo);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }
}
