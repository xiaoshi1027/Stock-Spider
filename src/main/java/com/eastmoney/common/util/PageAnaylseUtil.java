package com.eastmoney.common.util;

import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;

/**
 * 解析返回的page
 * @Author xiaoshi
 * @Date 2021/12/12 21:14
 * @Version
 **/
public class PageAnaylseUtil {
    public static JSONObject getData(Page page) {
        String pageString = page.getRawText();
        int startIndex = pageString.indexOf("(");
        int endIndex = pageString.lastIndexOf(")");
        String jsonString = pageString.substring(startIndex + 1, endIndex);
        JSONObject pageJson = JSONObject.parseObject(jsonString);
        JSONObject dataJson = pageJson.getJSONObject("data");
        return dataJson;
    }
}
