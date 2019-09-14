package com.fj.eureka.config;

import com.fj.eureka.config.configuration.MyConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;


/**
 * spring-boot启动类（在单元测的时候起作用）
 *
 * @author ji_fei
 * 2018年9月9日 下午6:18:22
 * @version v1.0
 */
@SpringBootApplication
// 指定Bean扫描路径
@ComponentScan(basePackages = {"com.fj.eureka.config", "com.fj.eureka.app"})
//指定Mapper扫描路径
@MapperScan(basePackages = {"com.fj.eureka.app.**.dao"})
// 属性配置类
@EnableConfigurationProperties(MyConfig.class)
// 扫描属性配置文件
@PropertySource({"classpath:jdbc.properties", "classpath:wxpay.properties"})
// Servlet扫描
@ServletComponentScan(basePackages = {"com.fj.boot.app.servlet"})
@EnableAspectJAutoProxy
//@EnableDiscoveryClient
//@EnableEurekaClient
@EnableEurekaServer
public class BootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAppApplication.class, args);
        System.out.println();
    }
}
