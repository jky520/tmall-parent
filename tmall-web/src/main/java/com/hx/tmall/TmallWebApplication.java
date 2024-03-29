package com.hx.tmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableDubbo
@MapperScan(basePackages = {"com.hx.tmall.dao"})
public class TmallWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmallWebApplication.class, args);
    }
    // 单体项目（适合小项目）
    // 分布式项目(适合大型项目)

}
