package com.itmuch.contentcenter.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class NacosWeightedRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //读取配置文件并初始化 暂时用不上 留空
    }

    @Override
    public Server choose(Object key) {
        try {
            //loadBalancer Ribbon入口 想要的都能拿到
            //我需要一个gateName API 但是 loadBalancer没有 所以需要强转 BaseLoadBalancer
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            //想要请求微服务的名称
            String name = loadBalancer.getName();
            //实现负载均衡算法  nacos有提供 注入一下 NacosDiscoveryProperties
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
            //nacos client 自动通过基于权重的负载均衡算法 给我门选择一个实例
            Instance instance = namingService.selectOneHealthyInstance(name);
            log.info("选择的实例是 prot={},instance={}",instance.getPort(),instance);
            //使用 NacosServer 将  Instance 转换成Server
            return new NacosServer(instance);
        } catch (NacosException e) {
            return null;
        }

    }
}











