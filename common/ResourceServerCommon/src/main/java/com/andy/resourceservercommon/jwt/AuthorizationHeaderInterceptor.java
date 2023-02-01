package com.andy.resourceservercommon.jwt;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

/**
 * @Description RestTemplate 请求拦截器，用于将JWT token 嵌入RestTemplate到请求中
 * @Author gaojie
 * @Data 2023/2/1 09:33
 */
public class AuthorizationHeaderInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        HttpHeaders httpHeaders = request.getHeaders();
        httpHeaders.add(AuthorizationHeader.AUTHORIZATION_HEADER,AuthorizationHeaderHolder.getAuthorizationHeader().getAuthorization());
        return execution.execute(request,body);
    }
}
