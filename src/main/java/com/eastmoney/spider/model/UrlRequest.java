package com.eastmoney.spider.model;

import lombok.Data;
import lombok.ToString;

/**
 * 请求信息
 * @Author xiaoshi
 * @Date 2021/12/12 13:08
 * @Version
 **/
@Data
@ToString
public class UrlRequest {
    // 请求地址
    private String url;

    /**
     * 参数
     */
    //
    private final static String cb = "jQuery112406074246312303457_1608308070107";

    // 页数
    private Integer pn = 1;

    // 行数
    private Integer pz = 5000;

    // 排序
    private Integer po = 0;

    private Integer np = 1;

    private final static String ut = "bd1d9ddb04089700cf9c27f6f7426281";

    private Integer fltt = 2;

    private Integer invt = 2;

    // 排序字段
    private String fid = "f12";

    // 取数匹配规则
    private String fs;

    // 查找字段 f12,f14
    private String fields = "f12,f14";

    // long类型的时间戳
    private String timestamp;

    private final static String QF = "?";
    private final static String AF = "&";

    public UrlRequest(String url, String fields, String timestamp) {
        this.url = url;
        this.fields = fields;
        this.timestamp = timestamp;
    }

    public String createUrl() {
        StringBuffer str = new StringBuffer();
        str.append(url).append(QF);
        str.append("cb=").append(cb).append(AF);
        str.append("pn=").append(pn).append(AF);
        str.append("pz=").append(pz).append(AF);
        str.append("po=").append(po).append(AF);
        str.append("np=").append(np).append(AF);
        str.append("ut=").append(ut).append(AF);
        str.append("fltt=").append(fltt).append(AF);
        str.append("invt=").append(invt).append(AF);
        str.append("fid=").append(fid).append(AF);
        str.append("fs=").append(fs).append(AF);
        str.append("fields=").append(fields).append(AF);
        str.append("_=").append(timestamp);

        return str.toString();
    }
}
