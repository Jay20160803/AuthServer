package com.andy.authserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/13 10:07
 */
@RestController
public class UserController {


    @GetMapping("/userInfo")
    public Object userInfo(OAuth2Authentication authentication){
        return authentication;
    }


    /**
     * 全局方法安全验证
     * @param authentication
     * @return
     */
    @PreAuthorize("hasAnyAuthority('user.read')")
    @GetMapping("/userInfo_11")
    public Object userInfo11(OAuth2Authentication authentication){
        return authentication;
    }
}
