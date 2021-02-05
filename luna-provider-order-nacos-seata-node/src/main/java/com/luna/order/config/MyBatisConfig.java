package com.luna.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author luna_mac
 */
@Configuration
@MapperScan({"com.luna.order.mapper"})
public class MyBatisConfig {}
