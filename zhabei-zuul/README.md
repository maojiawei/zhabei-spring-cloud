# zhabei-zuul
zuul主要为项目的API网关。

## 项目依赖
1. zuul模块。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
```

## 项目启动类
在项目启动类上添加`@EnableDiscoveryClient`注解，可以将服务注册至Eureka。  
在项目启动类上添加`@EnableZuulProxy`注解，默认为Zuul项目。  
```
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
```


## 配置文件
server.port为项目端口。
spring.application.name为项目名称。
eureka.client.serviceUrl.serviceUrl为eureka的地址。
```
server:
  port: 8098
spring:
  application:
    name: zhabei-zuul
eureka:
  client:
    service-url:
      default-zone: http://localhost:8761/eureka/
```

## 启动
启动zuul项目，可以通过 localhost:8098/{项目名称}/add
