package com.eastmoney.stock;

import org.junit.Test;

/**
 * @Author xiaoshi
 * @Date 2021/12/12 16:01
 * @Version
 **/
public class FsTest {
    @Test
    public void testFs() {
        for (int i = 30; i < 100; i++) {
            StringBuffer fs = new StringBuffer();
            for (int j = 0; j < 100; j++) {
                fs.append("m:").append(i).append("+t:").append(j).append(",");
            }
            System.out.println(fs.substring(0, fs.length() - 1));
        }
    }
}
