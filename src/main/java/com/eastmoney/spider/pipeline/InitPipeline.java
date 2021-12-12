package com.eastmoney.spider.pipeline;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eastmoney.stock.entity.StockInfo;
import com.eastmoney.stock.mapper.StockInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;

/**
 * @Author xiaoshi
 * @Date 2021/12/12 14:36
 * @Version
 **/
@Slf4j
@Component
public class InitPipeline implements Pipeline {
    @Resource
    private StockInfoMapper stockInfoMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        if (resultItems.isSkip()) {
            return;
        }
        JSONArray dataList = resultItems.get("dataList");
        if (dataList != null && !dataList.isEmpty()) {
            stockInfoMapper.delete(null);
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                JSONObject stockInfoJson = dataList.getJSONObject(i);
                String code = stockInfoJson.getString("f12");
                String name = stockInfoJson.getString("f14");
                Integer market = stockInfoJson.getInteger("f27");

                StockInfo stockInfo = new StockInfo();
                stockInfo.setCode(code);
                stockInfo.setName(name);
                stockInfo.setMarket(market);
                stockInfoMapper.insert(stockInfo);
            }
            log.info("save StockInfoPipeline to Mysql success! size:{}", size);
        }

    }
}
