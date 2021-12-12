DROP TABLE `s_stock_kline`;
CREATE TABLE `s_stock_kline` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `s_code` VARCHAR(100) NOT NULL COMMENT '代码——f12',
  `s_name` VARCHAR(100) NOT NULL COMMENT '名称——f14',
  `d_jy` DATE DEFAULT NULL COMMENT '交易日期（yyyy-MM-dd）',
  `n_open` VARCHAR(20) DEFAULT NULL COMMENT '开盘价——f17',
  `n_close` VARCHAR(20) DEFAULT NULL COMMENT '收盘价——f2',
  `n_high` VARCHAR(20) DEFAULT NULL COMMENT '最高价——f15',
  `n_low` VARCHAR(20) DEFAULT NULL COMMENT '最低价——f16',
  `n_zdf` VARCHAR(20) DEFAULT NULL COMMENT '涨跌幅(%)——f3',
  `n_zde` VARCHAR(20) DEFAULT NULL COMMENT '涨跌额——f4',
  `n_cjl` VARCHAR(50) DEFAULT NULL COMMENT '成交量(手)——f5',
  `n_cje` VARCHAR(50) DEFAULT NULL COMMENT '成交额——f6',
  `n_zf` VARCHAR(20) DEFAULT NULL COMMENT '振幅(%)——f7',
  `n_hsl` VARCHAR(20) DEFAULT NULL COMMENT '换手率(%)——f8',
  `d_create` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `d_modified` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
   PRIMARY KEY (`id`),
   UNIQUE KEY `index_s_stock_kline_code_date` (`s_code`,`d_jy`)
) COMMENT='股票k线数据表';

DROP TABLE `s_trade_kline`;
CREATE TABLE `s_trade_kline` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `s_code` VARCHAR(100) NOT NULL COMMENT '代码——f12',
  `s_name` VARCHAR(100) NOT NULL COMMENT '名称——f14',
  `d_jy` DATE DEFAULT NULL COMMENT '交易日期（yyyy-MM-dd）',
  `n_open` VARCHAR(20) DEFAULT NULL COMMENT '开盘价——f17',
  `n_close` VARCHAR(20) DEFAULT NULL COMMENT '收盘价——f2',
  `n_high` VARCHAR(20) DEFAULT NULL COMMENT '最高价——f15',
  `n_low` VARCHAR(20) DEFAULT NULL COMMENT '最低价——f16',
  `n_zdf` VARCHAR(20) DEFAULT NULL COMMENT '涨跌幅(%)——f3',
  `n_zde` VARCHAR(20) DEFAULT NULL COMMENT '涨跌额——f4',
  `n_cjl` VARCHAR(50) DEFAULT NULL COMMENT '成交量(手)——f5',
  `n_cje` VARCHAR(50) DEFAULT NULL COMMENT '成交额——f6',
  `n_zf` VARCHAR(20) DEFAULT NULL COMMENT '振幅(%)——f7',
  `n_hsl` VARCHAR(20) DEFAULT NULL COMMENT '换手率(%)——f8',
  `d_create` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `d_modified` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
   PRIMARY KEY (`id`),
   UNIQUE KEY `index_s_trade_kline_code_date` (`s_code`,`d_jy`)
) COMMENT='板块k线数据表';

DROP TABLE `s_stock_info`;
CREATE TABLE `s_stock_info` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `code` VARCHAR(8) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '股票代码',
  `name` VARCHAR(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '股票名称',
  `market` INT DEFAULT NULL COMMENT '市场（0:深证A股，1:上证A股）',
  `industry` VARCHAR(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '行业（多个行业中间使用逗号隔开）',
  `city` VARCHAR(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '城市',
  `open_status` INT DEFAULT NULL COMMENT '股票状态（0:正常交易，1:）',
  `type` INT DEFAULT NULL COMMENT '股票类型（0:正常，1:ST）',
  `listing_date` DATE DEFAULT NULL COMMENT '上市日期（yyyy-MM-dd）',
  `gmt_create` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)  COMMENT='股市代码信息表';


