# zhabei-config-server
config-server为配置中心的服务项目

## 项目依赖
1. 模块。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

## 项目启动类
在项目启动类上添加`@EnableDiscoveryClient`注解，可以将服务注册至Eureka。  
在项目启动类上添加`@EnableConfigServer`注解，默认为配置中心项目。  
```
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```


## 配置文件
server.port为项目端口。
spring.application.name为项目名称。
spring.cloud.config.server为spring cloud对应的配置文件的存放地址，本文对应的项目为https://github.com/maojiawei/zhabei-spring-cloud-repo。
```
server:
  port: 8888
spring:
  application:
    name: config-server
  cloud:
    config:
      server:
        git:
          uri: https://github.com/maojiawei/zhabei-spring-cloud-repo #default Config Server Uri
          search-paths: repos
      label: master

```


