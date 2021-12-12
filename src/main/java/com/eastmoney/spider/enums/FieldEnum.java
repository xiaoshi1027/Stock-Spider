package com.eastmoney.spider.enums;

/**
 * 东财的字段
 * @Author xiaoshi
 * @Date 2021/12/12 19:41
 * @Version
 **/
public enum FieldEnum {
    f2("f2","收盘价","n_close"),
    f3("f3","涨跌幅(%)","n_zdf"),
    f4("f4","涨跌额","n_zde"),
    f5("f5","成交量","n_cjl"),
    f6("f6","成交额","n_cje"),
    f7("f7","振幅(%)","n_zf"),
    f8("f8","换手率(%)","n_hsl"),
    f9("f9","市盈率(%)","n_syl"),
    f10("f10","量比","n_lb"),
    f11("f11","","n_wz1"),
    f12("f12","板块编码","s_code"),
    f14("f14","板块名称","s_name"),
    f15("f15","最高价","n_high"),
    f16("f16","最低价","n_low"),
    f17("f17","开盘价","n_open"),
    f18("f18","昨收","n_yclose"),
    f20("f20","总市值","n_zsz"),
    f21("f21","流通市值","n_ltsz"),
    f22("f22","涨速","n_zs"),
    f23("f23","市净率","n_sjl"),
    f24("f24","","n_wz2"),
    f45("f45","净利润","n_jlr"),
    f49("f49","毛利率","n_mll"),
    f62("f62","主力净流入","n_zljlr"),
    f66("f66","超大单净流入","n_cddjlr"),
    f69("f69","超大单净流入占比","n_cddjlr_jzb"),
    f72("f72","大单净流入","n_ddjlr"),
    f75("f75","大单净流入占比","n_ddjlr_jzb"),
    f78("f78","中单净流入","n_zdjlr"),
    f81("f81","中单净流入占比","n_zdjlr_jzb"),
    f84("f84","小单净流入","n_xdjlr"),
    f87("f87","小单净流入占比","n_xdjlr_jzb"),
    f104("f104","上涨家数","n_szjs"),
    f105("f105","下跌家数","n_xdjs"),
    f106("f106","走平家数","n_pjs"),
    f113("f113","每股净资产","n_mgjzc"),
    f128("f128","领涨股","n_lzg"),
    f140("f140","领涨股代码","n_lzg_code"),
    f184("f184","增仓比(除以100)","n_zcb"),

    kline("f2,f3,f4,f5,f6,f7,f8,f12,f14,f15,f16,f17", "K线表", "s_*_kline"),
    fields2("f51,f52,f53,f54,f55,f56,f57,f58,f59,f60,f61", "K线表", "s_*_kline");


    // 东财的字段名
    private String field;
    // 注释
    private String comment;
    // 本地的字段或者本地的表
    private String localField;

    FieldEnum(String field, String comment, String localField) {
        this.field = field;
        this.comment = comment;
        this.localField = localField;
    }

    public String getField() {
        return field;
    }

    public String getComment() {
        return comment;
    }

    public String getLocalField() {
        return localField;
    }
}
