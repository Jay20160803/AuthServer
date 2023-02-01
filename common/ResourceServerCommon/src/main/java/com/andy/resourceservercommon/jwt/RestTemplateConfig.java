package com.andy.resourceservercommon.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/2/1 09:40
 */
@Configuration
public class RestTemplateConfig {

    /**
     * RestTemplate 嵌入JWT token 添加拦截器
     * @return
     */
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

        if(CollectionUtils.isEmpty(interceptors)){
            restTemplate.setInterceptors(Collections.singletonList(new AuthorizationHeaderInterceptor()));
        }else {
            interceptors.add(new AuthorizationHeaderInterceptor());
            restTemplate.setInterceptors(interceptors);
        }

        return restTemplate;
    }
}
