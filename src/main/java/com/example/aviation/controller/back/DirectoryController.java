package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.entity.Directory;
import com.example.aviation.service.DirectoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/15 星期六 01:57
 */
@RestController
@RequestMapping("/directory")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DirectoryController {
    @Resource
    private DirectoryService directoryService;

    /**
     * 根据法规id查询该法规的目录
     * @param directoryId
     * @return
     */
    @RequestMapping("/selectDirectoryById2")
    public String selectDirectoryById(@RequestParam("directoryId") Integer directoryId){
        Map<String, Object> map = directoryService.selectTree(directoryId);
        return JSON.toJSONString(map);
    }

    /**
     * 给法规添加顶级目录
     * @return
     */
    @RequestMapping("/addOneDirectoryById")
    public String addOneDirectoryById(@RequestBody Directory directory){
      Map<String,Object>map= directoryService.addOneDirectoryById(directory);
        return JSON.toJSONString(map);
    }


    /**
     * 某个法规添加子目录
     * @return
     */
    @RequestMapping("/addZiDirectory")
    public String addZiDirectory( Directory directory){
        return JSON.toJSONString(directoryService.addZiDirectory(directory));
    }

    /**
     * 删除目录
     * @return
     */
    @RequestMapping("/delDirectory")
    public String delDirectory( Directory directory) throws Exception {
        return JSON.toJSONString(directoryService.delDirectory(directory));
    }

    /**
     * 修改目录
     * @return
     */
    @RequestMapping("/updateDirectoryById")
    public String updateDirectory(@RequestBody Directory directory) throws Exception {
        return JSON.toJSONString(directoryService.updateDirectoryById(directory));
    }
}
