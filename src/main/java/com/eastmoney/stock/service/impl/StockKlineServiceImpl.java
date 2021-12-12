package com.eastmoney.stock.service.impl;

import com.eastmoney.stock.entity.StockKline;
import com.eastmoney.stock.mapper.StockKlineMapper;
import com.eastmoney.stock.service.StockKlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 股票k线数据表 服务实现类
 * </p>
 *
 * @author kf-chenzm
 * @since 2021-12-12
 */
@Service
public class StockKlineServiceImpl extends ServiceImpl<StockKlineMapper, StockKline> implements StockKlineService {

}
