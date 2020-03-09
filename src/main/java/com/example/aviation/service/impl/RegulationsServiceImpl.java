package com.example.aviation.service.impl;

import com.example.aviation.mapper.ClauseMapper;
import com.example.aviation.mapper.DirectoryMapper;
import com.example.aviation.mapper.RegulationsMapper;
import com.example.aviation.model.dto.RegulationsDto;
import com.example.aviation.model.entity.Regulations;
//import com.example.aviation.model.vo.RegulationsAndTypeAndClassify;
import com.example.aviation.service.RegulationsService;
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
 * @date 2020/2/11 星期二 21:23
 */
@Service
public class RegulationsServiceImpl implements RegulationsService {
    @Resource
    private RegulationsMapper regulationsMapper;
    @Resource
    private DirectoryMapper directoryMapper;
    @Resource
    private ClauseMapper clauseMapper;
    @Override
    public Map<String, Object> selectRegulationsListVo(Map<String, Object> map) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("count",0);
        resultMap.put("code",2004);
        int page=Integer.parseInt(map.get("page").toString());
        int limit=Integer.parseInt(map.get("limit").toString());
        int index=(page-1)*limit;
        map.put("index",index);
        List<Regulations> list = regulationsMapper.selectList(map);
        Long num = regulationsMapper.selectListCount(map);
        if(num>0){
            resultMap.put("code",2001);
            resultMap.put("data",list);
            resultMap.put("count",num);
        }
        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> delRegulations(Integer regulationsId)throws RuntimeException, Exception{
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        //先根据法规id查询所有的目录的id
        List<Integer> integers = directoryMapper.selectDeprecatedIds(regulationsId);
        if(integers.size()==0){
            //没有目录直接删除法规
            Integer integer = regulationsMapper.delRegulationsById(regulationsId);
            if(integer>0){
                resultMap.put("msg","success");
                resultMap.put("code",2001);
                return  resultMap;
            }
            //没有目录删除失败
            return  resultMap;
        }else{
            //法规里面有目录，根据目录的id集合去查询对应的条款的主键
            List<Integer> list = clauseMapper.selectClauseId(integers);
            if(list.size()==0){
                //到这里就说明这个法规下有目录 目录里面没有条款
                //删除 目录
                Integer integer = directoryMapper.deleteDeprecated(regulationsId);
                //删除 法规
                Integer integer2 = regulationsMapper.delRegulationsById(regulationsId);
                if(integer>0&&integer2>0){
                    resultMap.put("msg","success");
                    resultMap.put("code",2001);
                    return  resultMap;
                }
                return resultMap;
            }else{
                //到这里就说明目录里面有条款
                //删除条款   根据目录的主键
                Integer integer3 = clauseMapper.delClause(integers);
                //删除 目录
                Integer integer = directoryMapper.deleteDeprecated(regulationsId);
                //删除 法规
                Integer integer2 = regulationsMapper.delRegulationsById(regulationsId);
                if(integer>0&&integer2>0&&integer3>0){
                    resultMap.put("msg","success");
                    resultMap.put("code",2001);
                    return  resultMap;
                    }
                }
            }

        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> addRegulations(RegulationsDto regulationsDto) throws RuntimeException, Exception {
        Map<String,Object>resultMap=new HashMap<String, Object>();
            resultMap.put("msg","failed");
            resultMap.put("code",2004);
            Integer integer = regulationsMapper.addRegulations(regulationsDto);
            if(integer>0){
                resultMap.put("msg","success");
                resultMap.put("code",2001);
            }
        return resultMap;
    }

    @Override
    public Map<String, Object> selectRegulationsByRegulationsId(Integer regulationsId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Regulations re = regulationsMapper.selectRegulationsByRegulationsId(regulationsId);
        if(re!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",re);
        }
        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> updateRegulations(RegulationsDto regulationsDto)throws RuntimeException, Exception {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer integer = regulationsMapper.updateRegulations(regulationsDto);
        if(integer>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> showRegulationsNameAndId(Integer cid) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
       List<Regulations> list= regulationsMapper.selectRegulationsNameAndId(cid);
        if(list.size()>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",list);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> showAllRegulationsNameAndId() {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<Regulations> list= regulationsMapper.selectAllRegulationsNameAndId();
        if(list.size()>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",list);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> showRegulations() {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<Regulations> list= regulationsMapper.showRegulations();
        if(list!=null){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",list);
        }
        return resultMap;
    }
}
