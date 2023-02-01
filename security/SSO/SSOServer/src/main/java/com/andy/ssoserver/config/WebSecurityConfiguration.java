package com.andy.ssoserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description 认证、授权配置
 * @Author gaojie
 * @Data 2023/2/1 10:19
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsServiceBean())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web){
        web.ignoring()
                .antMatchers("/assets/**","/css/**","/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .cors();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean(){
        Collection<UserDetails> users = buildUsers();
        return new InMemoryUserDetailsManager(users);
    }

    private Collection<UserDetails> buildUsers(){
        String password = passwordEncoder().encode("12345");

        List<UserDetails> users = new ArrayList<>();
        UserDetails userAdmin = User.withUsername("admin").password(password).authorities("ADMIN","USER").build();
        users.add(userAdmin);

        return users;
    }
}
