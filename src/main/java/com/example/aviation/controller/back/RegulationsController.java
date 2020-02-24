package com.example.aviation.controller.back;

import com.alibaba.fastjson.JSON;
import com.example.aviation.model.dto.RegulationsDto;
import com.example.aviation.service.RegulationsService;
import com.example.aviation.utils.QNYUtils;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: aviation
 * @Package com.example.aviation.controller.back
 * @Description:
 * @date 2020/2/11 星期二 21:29
 */
@RestController
@RequestMapping("/regulations")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegulationsController {
    @Resource
    private RegulationsService regulationsService;
    @Resource
    private QNYUtils qnyUtils;

    /**
     * 法规列表
     * @param limit 每页记录数
     * @param page 当前页码号
     * @return
     */
    @RequestMapping("/showRegulations")
    public String showRegulations(@RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit,
                                  @RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
        Map<String ,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("limit",limit);
        Map<String, Object> map1 = regulationsService.selectRegulationsListVo(map);
        return JSON.toJSONString(map1);
    }

    /**
     * 删除法规包含目录和条款
     * @param regulationsId
     * @return
     */
    @RequestMapping(value = "/delRegulations")
    public String delRegulations(@RequestParam(value = "regulationsId") Integer regulationsId) throws Exception {
            return JSON.toJSONString(regulationsService.delRegulations(regulationsId));

    }

    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping(value = "/doUpload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        String name = file.getOriginalFilename();
        DefaultPutRet defaultPutRet=null;
        Map<String,Object>map=new HashMap<>();
        try {
            Response response = qnyUtils.upload(file.getInputStream(), name);
            defaultPutRet = qnyUtils.defaultPutRet(response);
        } catch (Exception e) {
            map.put("status","failed");
            map.put("code",2004);
            e.printStackTrace();
        }
        if(defaultPutRet.key!=null&&defaultPutRet.key!=""){
            map.put("status","success");
            map.put("code",2001);
            //文件返回的文件路径
            map.put("url",qnyUtils.getPath()+defaultPutRet.key);
            //返回存储在七牛云上的key,用于删除
            map.put("key",defaultPutRet.key);
        }
        return JSON.toJSONString(map);
    }

    /**
     * 删除文件
     * @param key
     * @return
     */
    @RequestMapping("/delFile")
    public String delFiile(@RequestParam("key") String key){
        Map<String,Object>map=new HashMap<>();
        try {
           qnyUtils.delete(key);
            map.put("status","success");
            map.put("code",2001);
        } catch (Exception e) {
            map.put("status","failed");
            map.put("code",2004);
            e.printStackTrace();
        }finally {
            return JSON.toJSONString(map);
        }
    }

    /**
     * 添加法规
     * @param regulationsDto
     * @return
     */
    @RequestMapping("/addRegulations")
    public String addAddRegulationsDto(@RequestBody RegulationsDto regulationsDto) throws Exception {
       return JSON.toJSONString(regulationsService.addRegulations(regulationsDto));
    }

    /**
     * 修改法规
     * @param regulationsDto
     * @return
     */
    @RequestMapping("/updateRegulations")
    public String updateRegulationsDto(@RequestBody RegulationsDto regulationsDto) throws Exception {
        return JSON.toJSONString(regulationsService.updateRegulations(regulationsDto));
    }

    /**
     * 查询某一条法规
     * @param regulationsId
     * @return
     */
    @RequestMapping("/selectRegulationsByRegulationsId")
    public String selectRegulationsByRegulationsId(@RequestParam("regulationsId") Integer regulationsId){
        return JSON.toJSONString(regulationsService.selectRegulationsByRegulationsId(regulationsId));
    }


    /**
     * 查询某个二级分类下的法规的名称和主键
     *
     * @return
     */
    @RequestMapping("/showRegulationsNameAndId")
    public String showRegulationsNameAndId(@RequestParam("cid") Integer cid){
        return JSON.toJSONString(regulationsService.showRegulationsNameAndId(cid));
    }

    /**
     * 查询某个二级分类下的法规的名称和主键
     *
     * @return
     */
    @RequestMapping("/showAll")
    public String showAllRegulationsNameAndId(){
        return JSON.toJSONString(regulationsService.showAllRegulationsNameAndId());
    }
}
