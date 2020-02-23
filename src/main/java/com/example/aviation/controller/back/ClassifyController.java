package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.service.ClassifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/13 星期四 02:04
 */
@RestController
@RequestMapping("/cassify")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClassifyController {
    @Resource
    private ClassifyService classifyService;

    /**
     * 根据一级分类展示二级分类列表
     * @param regulationsTypeId
     * @return
     */
    @RequestMapping("/classifyList")
    public String showClassifyList(@RequestParam("regulationsTypeId")Integer regulationsTypeId){
        return JSON.toJSONString(classifyService.queryClassifyByRegulationsTypeId(regulationsTypeId));
    }

    /**
     * 根据二级分类cid  修改cname
     * @param cid
     * @param cname
     * @return
     */
    @RequestMapping("/classifyUpdateByCid")
    public String classifyUpdateByCid(@RequestParam("cid")Integer cid,@RequestParam("cname")String cname){
        return JSON.toJSONString(classifyService.updateClassifyNameByCid(cname,cid));
    }



    /**
     * 删除二级分类
     * @param cid
     *
     * @return
     */
    @RequestMapping("/delClassifyByCid")
    public String delClassifyByCid(@RequestParam("cid")Integer cid){
        System.out.println(cid);
        return JSON.toJSONString(classifyService.delClassifyByCid(cid));
    }

    /**
     * 添加二级分类
     * @param
     *
     * @return
     */
    @RequestMapping("/addCassify")
    public String addCassify(@RequestParam("cname")String cname, @RequestParam("ck")Integer ck){
        return JSON.toJSONString(classifyService.addCassify(cname,ck));
    }



    /**
     * 根据cid 查询 ck相同的分类
     * @param
     *
     * @return
     */
    @RequestMapping("/selectCassifyByCid")
    public String selectCassifyByCid(@RequestParam("cid")Integer cid){
        return JSON.toJSONString(classifyService.selectCassifyByCid(cid));
    }
}
