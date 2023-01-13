# eureka-server

https://docs.spring.io/spring-cloud-netflix/docs/3.0.5/reference/html/#spring-cloud-eureka-server

# gateway-server

https://docs.spring.io/spring-cloud-gateway/docs/3.0.8/reference/html/#gateway-starter

# 整合eureka-client

https://docs.spring.io/spring-cloud-netflix/docs/3.0.5/reference/html/#service-discovery-eureka-clients

1.添加依赖

```xml

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
2.在配置中心添加注册中心配置
```yaml
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```

# 整合apollo

1.添加依赖

```xml

<dependency>
    <groupId>com.ctrip.framework.apollo</groupId>
    <artifactId>apollo-client</artifactId>
</dependency>
```

2.添加配置

```properties
spring.profiles.active=@spring.profiles.active@
#apollo 配置
app.id=100110
apollo.bootstrap.enabled=true
# will inject 'application', 'FX.apollo' and 'application.yml' namespaces in bootstrap phase
apollo.bootstrap.namespaces=application
# put apollo initialization before logging system initialization
apollo.bootstrap.eagerLoad.enabled=true

```

3.本地连接docker 启动的apollo

https://www.apolloconfig.com/#/zh/usage/java-sdk-user-guide?id=_1222-%e8%b7%b3%e8%bf%87apollo-meta-server%e6%9c%8d%e5%8a%a1%e5%8f%91%e7%8e%b0
在jvm 参数中直接指定config server地址

# AuthServer

授权服务基于 Spring Authorization Server

#

TBD:

1、项目docker部署

2、使用docker 仓库
