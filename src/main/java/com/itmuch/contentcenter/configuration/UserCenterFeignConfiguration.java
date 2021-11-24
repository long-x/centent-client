package com.itmuch.contentcenter.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 代码配置Feign日志级别
 * 这个类不要加 @Configuration 注解 否则就要挪到@ComponentScan注解扫描的包以外
 * 就变成了全局扫描，出现父子上下文问题
 *
 */
public class UserCenterFeignConfiguration {

    @Bean
    public Logger.Level level(){
        //让feign打印日志
        //不打印
//        Logger.Level.NONE
        //尽请求方法、URL、响应状态码及执行时间
//        Logger.Level.BASIC;
        //再BASIC基础上加上请求和响应的header
//        Logger.Level.HEADERS
        //记录请求和响应的header 、body和元数据
        return Logger.Level.FULL;
    }

}
