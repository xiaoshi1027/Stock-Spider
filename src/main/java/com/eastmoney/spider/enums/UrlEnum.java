package com.eastmoney.spider.enums;

/**
 * @Author xiaoshi
 * @Date 2021/12/12 13:06
 * @Version
 **/
public enum UrlEnum {
    LIST_URL("统计列表接口", "http://96.push2.eastmoney.com/api/qt/clist/get"),
    KLINE_URL("K线接口", "http://35.push2his.eastmoney.com/api/qt/stock/kline/get");

    private String name;
    private String value;

    private UrlEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
