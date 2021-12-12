package com.eastmoney.spider.processor;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @Author xiaoshi
 * @Date 2021/12/12 14:36
 * @Version
 **/
@Component
public class InitProcessor implements PageProcessor {
    private static Logger logger = LoggerFactory.getLogger(InitProcessor.class);

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void process(Page page) {
        String pageString = page.getRawText();

        // 获取括号中的内容jQuery112404910385653520972_1639216871234({})
        int startIndex = pageString.indexOf("(");
        int endIndex = pageString.lastIndexOf(")");
        String jsonString = pageString.substring(startIndex + 1, endIndex);
        JSONObject pageJson = JSONObject.parseObject(jsonString);

        /*
            {
                "data": {
                    "total": 1548,
                    "diff": []
            }
         */
        JSONObject data = pageJson.getJSONObject("data");
        if (data == null) {
            return;
        }
        JSONArray dataList = data.getJSONArray("diff");

        // 保存到页面
        page.putField("dataList", dataList);

        /*try {
            // 保存文件
            String path = "C:\\Users\\xiaoshi\\Desktop\\数据\\" + fileName;
            //path指定路径下的文件如不存在，则创建
            FileUtil.writeUtf8String(dataList.toJSONString(),path);
        }catch (IORuntimeException e){
            //抛出一个运行时异常(直接停止掉程序)
            logger.error("保存文件失败：{}", fileName);
        }*/
    }

    @Override
    public Site getSite() {
        return this.site;
    }
}
