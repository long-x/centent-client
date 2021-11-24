package com.itmuch.ribbonconfiguration;

import com.itmuch.contentcenter.configuration.NacosWeightedRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration {

    /**
     * nacos 负载权重配置
     * 返回自己定义的类  NacosWeightedRule
     */
    @Bean
    public IRule ribbonRule(){
        return new NacosWeightedRule();
    }


//    @Bean
//    public IRule ribbonRule(){
//        return new RandomRule();
//    }

    /**
     * Java代码配置其他配置项
     * 表1所示诸如此类
     */
//    @Bean
//    public IPing ping(){
//        return new PingUrl();
//    }

}
