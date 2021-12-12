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
 * 股市代码信息表
 * </p>
 *
 * @author kf-chenzm
 * @since 2021-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("s_stock_info")
public class StockInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 股票代码
     */
    private String code;

    /**
     * 股票名称
     */
    private String name;

    /**
     * 市场（0:深证A股，1:上证A股）
     */
    private Integer market;

    /**
     * 行业（多个行业中间使用逗号隔开）
     */
    private String industry;

    /**
     * 城市
     */
    private String city;

    /**
     * 股票状态（0:正常交易，1:）
     */
    private Integer openStatus;

    /**
     * 股票类型（0:正常，1:ST）
     */
    private Integer type;

    /**
     * 上市日期（yyyy-MM-dd）
     */
    private Date listingDate;

    private Date gmtCreate;

    private Date gmtModified;


}
