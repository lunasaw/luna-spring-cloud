package com.luna.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author luna_mac
 */
@Configuration
@MapperScan({"com.luna.account.mapper"})
public class MyBatisConfig {}
