package com.example.aviation.service.impl;

import com.example.aviation.mapper.ClassifyMapper;
import com.example.aviation.mapper.RegulationsMapper;
import com.example.aviation.model.entity.Classify;
import com.example.aviation.service.ClassifyService;
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
 * @date 2020/2/13 星期四 02:02
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyMapper classifyMapper;
    @Resource
    private RegulationsMapper regulationsMapper;

    @Override
    public Map<String, Object> queryClassifyByRegulationsTypeId(Integer regulationsTypeId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<Classify> list = classifyMapper.selectClassifyByRegulationsTypeId(regulationsTypeId);
        if(list.size()>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",list);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateClassifyNameByCid(String cname, Integer cid) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer = classifyMapper.updateClassifyByCid(cname, cid);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> delClassifyByCid(Integer cid) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        //根据分类查询该分类下的所有法规的主键
        List<Integer> list = regulationsMapper.selectRegulationsByCid(cid);
        if(list.size()>0){

                    //修改法规分类为0
                    Integer integer9=  regulationsMapper.updateRegulationsByRegulationsIdList(list);
                    //删分类
                    Integer integer8= classifyMapper.delClassifyByCid(cid);
                    if(integer9>0&&integer8>0){
                        resultMap.put("msg","success");
                        resultMap.put("code",2001);
                        System.out.println("进来了2");
                    }


        }else{
            //说明该分类下不存在法规 删除分类
         Integer integer= classifyMapper.delClassifyByCid(cid);
         if(integer>0){
             resultMap.put("msg","success");
             resultMap.put("code",2001);
            }
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> addCassify(String cname, Integer ck) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer = classifyMapper.addCassify(cname,ck);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> selectCassifyByCid(Integer cid) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List <Classify>list = classifyMapper.selectCassifyByCid(cid);
        if(list.size()>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",list);
        }
        return resultMap;
    }
}
