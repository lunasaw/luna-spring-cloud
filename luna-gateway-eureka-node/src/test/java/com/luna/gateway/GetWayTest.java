package com.luna.gateway;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author luna@mac
 * @className GetWayTest.java
 * @description TODO
 * @createTime 2021年01月27日 15:26:00
 */
public class GetWayTest {

    @Test
    public void testCreateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println(zonedDateTime);
    }

}
