package com.andy.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/31 18:03
 */
@Configuration
public class JwtTokenStoreConfig {

    @Bean
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter result = new JwtAccessTokenConverter();
        result.setSigningKey("123456");
        return result;
    }

    @Bean
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices result = new DefaultTokenServices();
        result.setTokenStore(jwtTokenStore());
        result.setReuseRefreshToken(true);
        return result;
    }
}
