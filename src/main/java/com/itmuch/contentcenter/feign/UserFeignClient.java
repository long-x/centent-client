package com.itmuch.contentcenter.feign;

import com.itmuch.contentcenter.configuration.UserCenterFeignConfiguration;
import com.itmuch.contentcenter.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "user-center",configuration = UserCenterFeignConfiguration.class)
//属性配置需要去掉 configuration属性
@FeignClient(name = "user-center")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Integer id);

}
