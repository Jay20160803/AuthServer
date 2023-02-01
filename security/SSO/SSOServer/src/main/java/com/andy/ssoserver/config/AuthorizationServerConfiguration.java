package com.andy.ssoserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/2/1 10:52
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public ClientDetailsService inMemoryClientDetailsService() throws Exception {
        return new InMemoryClientDetailsServiceBuilder()
                .withClient("app1")
                .secret(passwordEncoder.encode("app1_secret"))
                .scopes("all")
                .authorizedGrantTypes("authorization_code","refresh_token")
                .redirectUris("http://localhost:8001/app1/login")
                .accessTokenValiditySeconds(7200)
                .autoApprove(true)

                .and()

                .withClient("app2")
                .secret(passwordEncoder.encode("app2_secret"))
                .scopes("all")
                .authorizedGrantTypes("authorization_code","refresh_token")
                .redirectUris("http://localhost:8002/app2/login")
                .accessTokenValiditySeconds(7200)
                .autoApprove(true)
                .and().build();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.accessTokenConverter(jwtAccessTokenConverter())
                .tokenStore(jwtTokenStore());
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("123456");
        return jwtAccessTokenConverter;
    }
}

