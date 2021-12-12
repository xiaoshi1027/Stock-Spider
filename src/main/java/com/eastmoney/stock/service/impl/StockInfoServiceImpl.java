package com.eastmoney.stock.service.impl;

import com.eastmoney.stock.entity.StockInfo;
import com.eastmoney.stock.mapper.StockInfoMapper;
import com.eastmoney.stock.service.StockInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 股市代码信息表 服务实现类
 * </p>
 *
 * @author kf-chenzm
 * @since 2021-12-12
 */
@Service
public class StockInfoServiceImpl extends ServiceImpl<StockInfoMapper, StockInfo> implements StockInfoService {

}
