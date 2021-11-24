package com.itmuch.contentcenter.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

//    @Autowired
//    private ShareMapper shareMapper;
//    @GetMapping("/test")
//    public  List<Share>  test1(){
//        Share share = new Share();
//
//        share.setCreateTime(new Date());
//        share.setUpdateTime(new Date());
//        share.setAuthor("xj");
//        share.setCover("xxxx");
//        share.setTitle("alibaba");
//        this.shareMapper.insertSelective(share);
//        List<Share> shares = this.shareMapper.selectAll();
//
//        return shares;
//    }



    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 测试内容中心总能找到用户中心
     * @return
     */
    @GetMapping("/test2")
    public List<String>  getDiscoveryClient(){
        //查询指定服务所有实例信息
//        List<ServiceInstance> instances = this.discoveryClient.getInstances("user-center");
//        return instances;
        //查询当前服务发现组件里面注册了哪些微服务
        List<String> services = this.discoveryClient.getServices();
        return services;
    }














}
