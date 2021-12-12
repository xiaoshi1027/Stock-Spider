package com.eastmoney.spider.pipeline;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eastmoney.stock.entity.StockInfo;
import com.eastmoney.stock.entity.StockKline;
import com.eastmoney.stock.entity.TradeKline;
import com.eastmoney.stock.mapper.StockKlineMapper;
import com.eastmoney.stock.mapper.TradeKlineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author xiaoshi
 * @Date 2021/12/12 20:46
 * @Version
 **/
@Slf4j
@Component
public class KLinePipeline implements Pipeline {

    @Resource
    private StockKlineMapper stockKlineMapper;
    @Resource
    private TradeKlineMapper tradeKlineMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        if (resultItems.isSkip()) {
            return;
        }
        String code = resultItems.get("code");
        String name = resultItems.get("name");
        String market = resultItems.get("market");
        JSONArray klinesArray = resultItems.get("klines");
        int size = klinesArray.size();
        for (int i = 0; i < size; i++) {
            String data = klinesArray.getString(i);
            String[] split = data.split(",");
            if ("90".equals(market)) {
                TradeKline kline = new TradeKline();
                kline.setSCode(code);
                kline.setSName(name);
                kline.setDJy(DateUtil.parse(split[0], "yyyy-MM-dd"));
                kline.setNOpen(split[1]);
                kline.setNClose(split[2]);
                kline.setNHigh(split[3]);
                kline.setNLow(split[4]);
                kline.setNCjl(split[5]);
                kline.setNCje(split[6]);
                kline.setNZf(split[7]);
                kline.setNZdf(split[8]);
                kline.setNZde(split[9]);
                kline.setNHsl(split[10]);
                tradeKlineMapper.insert(kline);
            } else {
                StockKline kline = new StockKline();
                kline.setSCode(code);
                kline.setSName(name);
                kline.setDJy(DateUtil.parse(split[0], "yyyy-MM-dd"));
                kline.setNOpen(split[1]);
                kline.setNClose(split[2]);
                kline.setNHigh(split[3]);
                kline.setNLow(split[4]);
                kline.setNCjl(split[5]);
                kline.setNCje(split[6]);
                kline.setNZf(split[7]);
                kline.setNZdf(split[8]);
                kline.setNZde(split[9]);
                kline.setNHsl(split[10]);
                stockKlineMapper.insert(kline);
            }
        }
        log.info("save KlinePipeline to Mysql success! size:{}", size);
    }
}
