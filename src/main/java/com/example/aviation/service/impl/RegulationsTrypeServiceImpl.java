package com.example.aviation.service.impl;

import com.example.aviation.mapper.ClassifyMapper;
import com.example.aviation.mapper.RegulationsMapper;
import com.example.aviation.mapper.RegulationsTrypeMapper;
import com.example.aviation.model.entity.RegulationsTrype;
import com.example.aviation.model.vo.RegulationsTrypeAndClassify;
import com.example.aviation.service.RegulationsTrypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @date 2020/2/12 星期三 23:51
 */
@Service
public class RegulationsTrypeServiceImpl implements RegulationsTrypeService {
    @Resource
    private RegulationsTrypeMapper regulationsTrypeMapper;
    @Resource
    private ClassifyMapper classifyMapper;
    @Resource
    private RegulationsMapper regulationsMapper;
    @Override
    public Map<String, Object> selectRegulationsTypeAndClassify() {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<RegulationsTrypeAndClassify> list = regulationsTrypeMapper.selectAll();
        if(list.size()>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",list);
        }
        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> addOneType(String regulationsTypeName)throws Exception {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        try {
            resultMap.put("msg","failed");
            resultMap.put("code",2004);
            Integer integer = regulationsTrypeMapper.insertOneType(regulationsTypeName);
            if(integer>0){
                resultMap.put("msg","success");
                resultMap.put("code",2001);
            }
        }catch (Exception e){
            new RuntimeException();
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryAllOneType() {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<RegulationsTrype> list = regulationsTrypeMapper.selectAllOneType();
        if(list.size()>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",list);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> delregulationsTrype(Integer regulationsTypeId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<Integer> list = classifyMapper.selectCassifyByCk(regulationsTypeId);
        if(list.size()>0){
          List<Integer> integer2=  regulationsMapper.selectRegulationsByCidList(list);
          if(integer2.size()>0){
              Integer integer4 = regulationsMapper.updateRegulationsByRegulationsIdList(integer2);
              Integer integer3= classifyMapper.delClassifyByCidList(list);
              Integer integer= regulationsTrypeMapper.delregulationsTrype(regulationsTypeId);
              if(integer>0&&integer3>0&&integer4>0){
                  resultMap.put("msg","success");
                  resultMap.put("code",2001);
              }
          }else{
             Integer integer3= classifyMapper.delClassifyByCidList(list);
              Integer integer= regulationsTrypeMapper.delregulationsTrype(regulationsTypeId);
              if(integer3>0&&integer>0){
                  resultMap.put("msg","success");
                  resultMap.put("code",2001);
              }
          }
        }else{
         Integer integer= regulationsTrypeMapper.delregulationsTrype(regulationsTypeId);
            if(integer>0){
                resultMap.put("msg","success");
                resultMap.put("code",2001);
            }
        }
        return resultMap;
    }
}
