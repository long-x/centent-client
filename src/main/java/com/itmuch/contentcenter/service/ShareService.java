package com.itmuch.contentcenter.service;

import com.itmuch.contentcenter.dao.content.ShareMapper;
import com.itmuch.contentcenter.domain.dto.ShareDTO;
import com.itmuch.contentcenter.domain.dto.UserDTO;
import com.itmuch.contentcenter.domain.entity.content.Share;
import com.itmuch.contentcenter.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {

    @Autowired
    private final ShareMapper shareMapper;
//    @Autowired
//    private final RestTemplate restTemplate;
    @Autowired
    private UserFeignClient userFeignClient;

    //引入Ribbon可以不通过  discoveryClient 获取请求数据
//    @Autowired
//    private DiscoveryClient discoveryClient;

    //Ribbon简化后的代码
    public ShareDTO findById(Integer id){
        //获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        //获取分享人id
        Integer userId = share.getUserId();
        //怎么调用user_center 获取用户信息呢
//        UserDTO userDTO = this.restTemplate.getForObject("http://user-center/user/{userId}", UserDTO.class, userId);
        UserDTO userDTO = userFeignClient.findById(userId);

        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share,shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

//    public ShareDTO findById(Integer id){
//        //获取分享详情
//        Share share = this.shareMapper.selectByPrimaryKey(id);
//        //获取分享人id
//        Integer userId = share.getUserId();
//        //怎么调用user_center 获取用户信息呢
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
////        String uri = instances.stream()
////                .map(e -> e.getUri().toString() + "/user/{id}")
////                .findFirst()
////                .orElseThrow(() -> new IllegalArgumentException("当前没有实例"));
//        List<String> uri = instances.stream()
//                .map(e -> e.getUri().toString() + "/user/{id}")
//                .collect(Collectors.toList());
//
////        UserDTO userDTO = this.restTemplate.getForObject("http://localhost:8080/user/{id}", UserDTO.class, userId);
//        //获取随机请求
//        int i = ThreadLocalRandom.current().nextInt(uri.size());
//        UserDTO userDTO = this.restTemplate.getForObject(uri.get(i), UserDTO.class, userId);
//        log.info("请求目标地址：{}",uri.get(i));
//
//        ShareDTO shareDTO = new ShareDTO();
//        BeanUtils.copyProperties(share,shareDTO);
//        shareDTO.setWxNickname(userDTO.getWxNickname());
//        return shareDTO;
//    }

    //测试 RestTemplate http调用
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8080/user/1", String.class);

        System.out.println(forObject);
    }



}
