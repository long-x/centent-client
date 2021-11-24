package com.itmuch.contentcenter;

import com.itmuch.contentcenter.configuration.UserCenterFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.itmuch")
@SpringBootApplication
//Feign java代码全局配置
//@EnableFeignClients(defaultConfiguration = UserCenterFeignConfiguration.class)
@EnableFeignClients
public class ContentCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCenterApplication.class, args);
	}

	//spring 管理RestTemplate 不用每次都new
	@Bean
	//引入Ribbon 在 RestTemplate 加上@LoadBalanced即可
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
