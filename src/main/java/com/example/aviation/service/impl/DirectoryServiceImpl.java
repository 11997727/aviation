package com.example.aviation.service.impl;

import com.example.aviation.mapper.ClauseMapper;
import com.example.aviation.mapper.DirectoryMapper;
import com.example.aviation.model.dto.RegulationsDirectory;
import com.example.aviation.model.dto.TreeNode;
import com.example.aviation.model.entity.Clause;
import com.example.aviation.model.entity.Directory;
import com.example.aviation.service.DirectoryService;
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
 * @date 2020/2/15 星期六 01:38
 */
@Service
public class DirectoryServiceImpl implements DirectoryService {
    @Resource
    private DirectoryMapper directoryMapper;
    @Resource
    private ClauseMapper clauseMapper;
    @Override
    public Map<String, Object> selectTree(Integer regulationsId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<TreeNode> treeNodes = directoryMapper.selectTreeNode(regulationsId);
        if(treeNodes.size()>0){
            List<TreeNode> tree = TreeNode.listGetStree(treeNodes);
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",tree);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> selectTree2(Integer regulationsId) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<RegulationsDirectory> regulationsDirectories = directoryMapper.selectTreeNode2(regulationsId);
        if(regulationsDirectories.size()>0){
            List<RegulationsDirectory> tree = RegulationsDirectory.listGetStree(regulationsDirectories);
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",tree);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> selectClauseBydirectoryForeignKey(Integer directoryForeignKey) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        List<Clause> clauses = clauseMapper.selectClauseBydirectoryForeignKey(directoryForeignKey);
        if(clauses.size()>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",clauses);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> addOneDirectoryById(Directory directory) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer num=directoryMapper.addOneDirectoryById(directory);
        if(num>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> addZiDirectory(Directory directory) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        Integer num=directoryMapper.addZiDirectory(directory);
        if(num>0){
            resultMap.put("msg","success");
            resultMap.put("code",2001);
            resultMap.put("data",directory.getDirectoryId());
        }
        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> delDirectory(Directory directory)throws Exception {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        try{
        //先查询出来要删除的目录主键
        List<Integer> list = directoryMapper.selectDirectoryIdByDirectoryKey(directory);
        list.add(directory.getDirectoryId());
        //查询该目录下的条款
        List<Integer> list1 = clauseMapper.selectClauseId(list);
        if(list1.size()>0){
            //到这里就说明目录里面包含条款，删除条款
            Integer integer = clauseMapper.delClause(list);
            //删除目录
            Integer integer1 = directoryMapper.delDirectorys(list);
            if(integer>0&&integer1>0){
                resultMap.put("msg","success");
                resultMap.put("code",2001);
            }
        }else{
             //到这里说明该目录下没有条款，直接删除目录
            Integer integer2 = directoryMapper.delDirectorys(list);
            if(integer2>0){
                resultMap.put("msg","success");
                resultMap.put("code",2001);
            }
        }
        }catch (Exception e){
           e.printStackTrace();
            new RuntimeException();
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateDirectoryById(Directory directory) throws Exception {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",2004);
        try {
        Integer integer=  directoryMapper.updateDirectoryById(directory);
            if(integer>0){
                resultMap.put("msg","success");
                resultMap.put("code",2001);
            }
        }catch (Exception e){
            e.printStackTrace();
            new RuntimeException();
        }
        return resultMap;
    }


}
