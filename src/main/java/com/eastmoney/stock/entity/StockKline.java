package com.eastmoney.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 股票k线数据表
 * </p>
 *
 * @author kf-chenzm
 * @since 2021-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("s_stock_kline")
public class StockKline implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 代码——f12
     */
    private String sCode;

    /**
     * 名称——f14
     */
    private String sName;

    /**
     * 交易日期（yyyy-MM-dd）
     */
    private Date dJy;

    /**
     * 开盘价——f17
     */
    private String nOpen;

    /**
     * 收盘价——f2
     */
    private String nClose;

    /**
     * 最高价——f15
     */
    private String nHigh;

    /**
     * 最低价——f16
     */
    private String nLow;

    /**
     * 涨跌幅(%)——f3
     */
    private String nZdf;

    /**
     * 涨跌额——f4
     */
    private String nZde;

    /**
     * 成交量(手)——f5
     */
    private String nCjl;

    /**
     * 成交额——f6
     */
    private String nCje;

    /**
     * 振幅(%)——f7
     */
    private String nZf;

    /**
     * 换手率(%)——f8
     */
    private String nHsl;

    /**
     * 创建日期
     */
    private Date dCreate;

    /**
     * 修改日期
     */
    private Date dModified;


}
