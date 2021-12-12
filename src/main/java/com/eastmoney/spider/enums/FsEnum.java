package com.eastmoney.spider.enums;

/**
 * @Description fs参数的相关值
 * @Author xiaoshi
 * @Date 2021/12/12 13:44
 * @Version
 **/
public enum FsEnum {
    fs00("00开头股票","m:0+t:6"),
    fs30("30开头股票","m:0+t:80"),
    fs60("60开头股票","m:1+t:2"),
    fs688("688开头股票","m:1+t:23"),
    fsBK("BK开头的板块指数","m:90+t:2");

    private String name;
    private String value;

    FsEnum(String name, String value) {
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
