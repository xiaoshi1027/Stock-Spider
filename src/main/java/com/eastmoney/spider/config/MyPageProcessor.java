package com.eastmoney.spider.config;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *  爬取分页
 *  @author kf-chenzm
 *  @since 2021-12-12
 */
public abstract class MyPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Override
    public abstract void process(Page page);

    @Override
    public Site getSite() {
        return this.site;
    }
}
