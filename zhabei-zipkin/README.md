# zhabei-zipkin
Zipkin主要是类似谷歌dapper或淘宝鹰眼的实现，与spring cloud Sleuth集成可以查看微服务之间的调用信息。  
本例主要使用rabbitmq传输数据，mysql存储数据。

## 项目依赖
1. turbine模块。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
</dependency>
```

## 项目启动类
在项目启动类上添加`@EnableDiscoveryClient`注解，可以将服务注册至Eureka。  
在项目启动类上添加`@EnableTurbineStream`注解，默认为Zipkin项目。  
```
@SpringBootApplication
@EnableZipkinStreamServer
@EnableDiscoveryClient
public class ZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }
}
```


## 配置文件
server.port为项目端口。
spring.application.name为项目名称。
spring.rabbitmq.host为rabbitmq的host地址、port为端口、username为用户名、password为用户密码。
spring.database.url为mysql的host地址、port为端口、username为用户名、password为用户密码。
eureka.client.serviceUrl.serviceUrl为eureka的地址。
turbine.appConfig主要为监控的服务。
```
spring:
  application:
    name: server-zipkin
  rabbitmq:
    username: admin
    password: admin
  datasource:
    username: root
    password: Accp1234
    url: jdbc:mysql://localhost/zipkin?useUnicode=yes&autoReconnect=true&useSSL=false
    initialize: true
    schema:
      - classpath:zipkin.sql
    continueOnError: true
  sleuth:
    enabled: false
#zipkin:
#  storage:
#    type: mysql
server:
  port: 8889
eureka:
  client:
    service-url:
      default-zone: http://localhost:8761/eureka/
```

## 启动
启动zipkin项目，并输入`localhst:8889`,即可看到界面。  
