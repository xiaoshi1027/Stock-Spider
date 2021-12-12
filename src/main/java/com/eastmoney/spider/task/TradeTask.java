package com.eastmoney.spider.task;

import com.eastmoney.spider.enums.FieldEnum;
import com.eastmoney.spider.enums.UrlEnum;
import com.eastmoney.spider.model.UrlRequest;
import com.eastmoney.spider.pipeline.KLinePipeline;
import com.eastmoney.spider.processor.KLineProcessor;
import com.eastmoney.stock.entity.StockInfo;
import com.eastmoney.stock.mapper.StockInfoMapper;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * 爬取板块相关信息任务
 * @Author xiaoshi
 * @Date 2021/12/12 12:59
 * @Version
 **/
@Component
public class TradeTask {
    @Resource
    private StockInfoMapper stockInfoMapper;
    @Resource
    private KLineProcessor kLineProcessor;
    @Resource
    private KLinePipeline kLinePipeline;

    @PostConstruct
    public void getTradeInfo() {
        // 获得3年内的所有k线
        getTradeKline(365*3);
    }

    public void getTradeKline(int limit) {

        Map<String, Object> selectMap = new HashMap<>();
        selectMap.put("market", "90");
        List<StockInfo> stockInfos = stockInfoMapper.selectByMap(selectMap);

        String[] urls = stockInfos.stream().map(stockInfo -> {
            UrlRequest urlRequest = new UrlRequest(UrlEnum.KLINE_URL.getValue(),"",
                    new Date().getTime() + "");
            urlRequest.setLmt(limit);
            urlRequest.setSecid(stockInfo.getMarket() + "." + stockInfo.getCode());
            urlRequest.setFields2(FieldEnum.fields2.getField());
            return urlRequest.createKlineUrl();
        }).toArray(String[]::new);

        Spider.create(kLineProcessor).addUrl(urls).addPipeline(kLinePipeline).run();
    }
}
