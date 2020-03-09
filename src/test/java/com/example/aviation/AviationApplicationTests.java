package com.example.aviation;

import com.alibaba.fastjson.JSON;
import com.example.aviation.mapper.ClauseMapper;
import com.example.aviation.mapper.DirectoryMapper;
import com.example.aviation.mapper.RegulationsMapper;
import com.example.aviation.mapper.RegulationsTrypeMapper;
import com.example.aviation.model.entity.Directory;
//import com.example.aviation.model.vo.RegulationsAndTypeAndClassify;
import com.example.aviation.model.vo.RegulationsTrypeAndClassify;
import com.example.aviation.service.DirectoryService;
import com.example.aviation.service.RegulationsService;
import com.example.aviation.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AviationApplicationTests {
    @Resource
    private ClauseMapper clauseMapper;
    @Resource
    private RegulationsService regulationsService;
    @Resource
    private RegulationsTrypeMapper regulationsTrypeMapper;
    @Resource
    private DirectoryMapper directoryMapper;
    @Resource
    private RegulationsMapper regulationsMapper;
    @Resource
    private DirectoryService directoryService;
    @Resource
    private RedisUtils redisUtils;

    @Test
    public void get(){
        Object o = redisUtils.judgeToken("token-Smartphone1679091c5a880faf6fb5e6087eb1b2dc202003042346433f4701");
        System.out.println(o.toString());
    }
    @Test
    public void contextLoads() {
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = clauseMapper.selectClauseId(list);
        //输出所有这几个目录里面的条款主键
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    //根据法规查询目录 的主键集合
    @Test
    public void test01(){
        List<Integer> list = directoryMapper.selectDeprecatedIds(1);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }



    //根据法规删除目录
    @Test
    public void test02(){

        Integer integer = directoryMapper.deleteDeprecated(6);
        if(integer>0){
            System.out.println("成功"+integer);
        }
    }
    @Test
    public void test03(){
        List<Integer> list=new ArrayList<>();
        list.add(6);
        list.add(4);
        Integer integer = clauseMapper.delClause(list);
        System.out.println("法规删除"+integer+"个");
    }

    @Test
    public void test04(){
        Map<String,Object>map=new HashMap<>();
        map.put("index",1);
        map.put("limit",5);
        List<RegulationsTrypeAndClassify> list = regulationsTrypeMapper.selectAll();
        for(RegulationsTrypeAndClassify r:list){
            System.out.println(r);
        }
    }
    @Test
    public void test05(){
//        RegulationsAndTypeAndClassify regulationsAndTypeAndClassify = regulationsMapper.selectRegulationsByRegulationsId(31);
//        System.out.println(regulationsAndTypeAndClassify);
    }

    @Test
    public void test06(){
        Map<String, Object> map = directoryService.selectTree(34);
        System.out.println(JSON.toJSONString(map));
    }

    @Test
    public void test07(){
        Directory directory=  new Directory();
        directory.setDirectoryKey("1");
        directory.setDirectoryNama("1");
        directory.setLevel(1);
        directory.setDistance(1);
        directory.setRegulationsForeignKey(1);
        directory.setParentId(1);
        Integer integer = directoryMapper.addZiDirectory(directory);
        System.out.println(integer);
        System.out.println(directory.getDirectoryId());
    }

    @Test
    public void test08(){
        System.out.println(System.currentTimeMillis());
    }
}
