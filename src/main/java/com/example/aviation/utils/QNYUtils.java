package com.example.aviation.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.StringMap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: qiniuyun
 * @Package com.example.qiniuyun.util
 * @Description:
 * @date 2020/1/8 星期三 11:49
 */
@Component
public class QNYUtils {
    @Resource
    private QNYConfig qnyConfig;

    /**
     * 生成token
     * @param key
     * @return
     */
    public String token(String key) {
        return qnyConfig.createAuth().uploadToken(qnyConfig.getBucket(), key, 3600, new StringMap().put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}"));
    }

    /**
     * 上传
     * @param is
     * @param key
     * @return
     * @throws QiniuException
     */
    public Response upload(InputStream is,String key)throws QiniuException {
        return qnyConfig.uploadManager().put(is,key,token(key),null,null);
    }
    //解析上传成成功的结果
    public DefaultPutRet defaultPutRet(Response response)throws QiniuException {
        return new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
    }

    /**
     * 获取前缀
     * @return
     */
    public String getPath(){
        return qnyConfig.getPath();
    }

    /**
     * 删除
     * @param key
     * @return
     */
    public void delete(String key)throws Exception{
        qnyConfig.bucketManager().delete(qnyConfig.getBucket(), key);
    }
}
