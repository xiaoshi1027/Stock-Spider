package com.eastmoney.spider.processor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eastmoney.common.util.PageAnaylseUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @Author xiaoshi
 * @Date 2021/12/12 20:45
 * @Version
 **/
@Slf4j
@Component
public class KLineProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Override
    public void process(Page page) {
        JSONObject dataJson = PageAnaylseUtil.getData(page);
        if (dataJson == null) {
            return;
        }

        String code = dataJson.getString("code");
        String name = dataJson.getString("name");
        String market = dataJson.getString("market");
        JSONArray klinesArray = dataJson.getJSONArray("klines");
        page.putField("klines", klinesArray);
        page.putField("code", code);
        page.putField("name", name);
        page.putField("market", market);
        log.info("code:{},name:{},market:{}", new Object[]{code, name, market});
    }

    @Override
    public Site getSite() {
        return this.site;
    }

}
