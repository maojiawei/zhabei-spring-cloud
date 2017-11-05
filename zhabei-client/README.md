# zhabei-client
项目主要为spring cloud客户端，也可以称为服务提供端(provider)。spring cloud主要采用restful方式提供服务。

## 项目依赖
1. spring boot针对web项目的依赖。
```
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
2. spring-boot-starter-actuator这个库让我们可以访问应用的很多信息，包括：/env、/info、/metrics、/health等。
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
3. spring-cloud针对Eureka项目的依赖。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```
4. spring-cloud-sleuth的一个模块。主要可以为zhabei-zipkin项目提供数据，将服务调用信息传递给zipkin。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-stream</artifactId>
</dependency>
```
5. spring-cloud-sleuth的一个模块。主要通过rabbitmq为zipkin提供服务模块调用的信息。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-stream-binder-rabbit</artifactId>
</dependency>
```

## 项目启动类
在项目启动类上添加`@EnableDiscoveryClient`注解，可以将服务注册至Eureka。
```
@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
```

## 项目接口
主要查看DemoController，直接暴露restful接口。

## 配置文件
server.port为项目端口。
spring.application.name为项目名称。
spring.rabbitmq.host为rabbitmq的host地址、port为端口、username为用户名、password为用户密码。
eureka.client.serviceUrl.serviceUrl为eureka的地址
```

server:
  port: 8080
spring:
  application:
      name: zhabei-client
  rabbitmq:
      host: localhost
      port: 5672
      username: admin
      password: admin
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```
