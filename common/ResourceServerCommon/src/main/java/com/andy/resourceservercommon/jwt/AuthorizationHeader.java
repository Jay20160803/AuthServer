package com.andy.resourceservercommon.jwt;

import lombok.Data;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/2/1 09:26
 */
@Data
public class AuthorizationHeader {

    public static final String AUTHORIZATION_HEADER = "authorization";

    private String authorization = new String();


}
