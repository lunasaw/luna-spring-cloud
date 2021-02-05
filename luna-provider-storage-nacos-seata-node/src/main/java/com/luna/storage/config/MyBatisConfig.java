package com.luna.storage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author luna_mac
 */
@Configuration
@MapperScan({"com.luna.storage.mapper"})
public class MyBatisConfig {}
