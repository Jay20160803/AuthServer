package com.andy.resourceservercommon.jwt;

import org.springframework.stereotype.Component;

/**
 * @Description AuthorizationHeader 线程安全保存
 * @Author gaojie
 * @Data 2023/2/1 09:29
 */
public class AuthorizationHeaderHolder {

    private static ThreadLocal<AuthorizationHeader> authorizationHeaderContext = new ThreadLocal<>();

    public static AuthorizationHeader getAuthorizationHeader() {
        AuthorizationHeader authorizationHeader = authorizationHeaderContext.get();

        if(null == authorizationHeader){
            authorizationHeaderContext.set(new AuthorizationHeader());
        }

        return authorizationHeaderContext.get();
    }

    public static void setAuthorizationHeader(AuthorizationHeader authorizationHeader) {
        authorizationHeaderContext.set(authorizationHeader);
    }
}
