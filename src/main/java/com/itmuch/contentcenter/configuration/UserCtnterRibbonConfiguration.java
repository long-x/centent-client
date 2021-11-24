package com.itmuch.contentcenter.configuration;

import com.itmuch.ribbonconfiguration.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * Java代码实现 Ribbon 负载均衡细粒度
 * name = "user-center" 只针对 user-center 模块
 * configuration = RibbonConfiguration.class 配置规则实现类
 */
@Configuration
//@RibbonClient(name = "user-center",configuration = RibbonConfiguration.class)
// ribbon全局配置  替换@RibbonClient 注解 修改参数
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class UserCtnterRibbonConfiguration {
}
