package com.eastmoney.spider.task;

import com.eastmoney.spider.enums.FsEnum;
import com.eastmoney.spider.enums.UrlEnum;
import com.eastmoney.spider.model.UrlRequest;
import com.eastmoney.spider.pipeline.InitPipeline;
import com.eastmoney.spider.processor.InitProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * 初始化个股、板块等信息
 * @Author xiaoshi
 * @Date 2021/12/12 13:06
 * @Version
 **/
@Component
public class InitInfoTask {
    @Autowired
    private InitProcessor initProcessor;

    @Autowired
    private InitPipeline initPipeline;

    @PostConstruct
    public void initInfo() {
        /*
        // 查看哪些fs规则中有数据，整理出对自己有用的fs
        for (int i = 0; i < 1000; i++) {
            StringBuffer fs = new StringBuffer();
            for (int j = 0; j < 100; j++) {
                fs.append("m:").append(i).append("+t:").append(j).append(",");
            }

            UrlRequest urlRequest = new UrlRequest(UrlEnum.LIST_URL.getValue(),
                    "f12,f14,f27", new Date().getTime() + "");
            urlRequest.setFs(fs.substring(0, fs.length() - 1));

            String url = urlRequest.createUrl();
            String fileName = new StringBuffer().append("m：").append(i)
                    .append("+t：").append("n").append(".txt").toString();

            initProcessor.setFileName(fileName);
            Spider.create(initProcessor).addUrl(url).run();
        }*/

        StringBuffer fs = new StringBuffer();
        fs.append(FsEnum.fs00.getValue()).append(",");
        fs.append(FsEnum.fs30.getValue()).append(",");
        fs.append(FsEnum.fs60.getValue()).append(",");
        fs.append(FsEnum.fs688.getValue()).append(",");
        fs.append(FsEnum.fsBK.getValue());

        UrlRequest urlRequest = new UrlRequest(UrlEnum.LIST_URL.getValue(),
                "f12,f14,f27", new Date().getTime() + "");
        urlRequest.setFs(fs.substring(0, fs.length() - 1));
        urlRequest.setPz(10000);
        String url = urlRequest.createUrl();
        Spider.create(initProcessor).addUrl(url).addPipeline(initPipeline).run();
    }
}
