package com.eastmoney.stock.service.impl;

import com.eastmoney.stock.entity.TradeKline;
import com.eastmoney.stock.mapper.TradeKlineMapper;
import com.eastmoney.stock.service.TradeKlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 板块k线数据表 服务实现类
 * </p>
 *
 * @author kf-chenzm
 * @since 2021-12-12
 */
@Service
public class TradeKlineServiceImpl extends ServiceImpl<TradeKlineMapper, TradeKline> implements TradeKlineService {

}
