package com.andy.resourceservercommon.jwt;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description 从HTTP请求中获取JWT令牌
 * @Author gaojie
 * @Data 2023/2/1 09:24
 */
@Component
public class AuthorizationHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
