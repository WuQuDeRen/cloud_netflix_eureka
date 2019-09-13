package com.fj.boot_app;

import com.fj.boot_app.configuration.MyConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * spring-boot启动类（在单元测的时候起作用）
 *
 * @author ji_fei
 * 2018年9月9日 下午6:18:22
 * @version v1.0
 */
@SpringBootApplication
// 指定Bean扫描路径
@ComponentScan(basePackages = {"com.fj.boot.app", "com.fj.boot_app.configuration"})
//指定Mapper扫描路径
@MapperScan(basePackages = {"com.fj.boot.app.**.dao"})
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
