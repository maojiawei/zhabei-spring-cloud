# zhabei-config-client
config-client为配置中心的服务项目的客户端。  


## 项目依赖
1. config项目依赖模块。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```
2. spring cloud的项目总线。  
spring cloud config可以与bus结合。通过amqp协议（本例为rabbitmq），可以实时对配置的信息进行更改。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```

## 项目启动类
```
@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
```


## 配置文件
server.port为项目端口。
spring.application.name为项目名称。
spring.rabbitmq.host为rabbitmq的host地址、port为端口、username为用户名、password为用户密码。
spring.cloud.config表示config-server的地址及对应信息。
```
server:
  port: 8889
spring:
  application:
    name: zhabei-foo    # 对应config server所获取的配置文件的{application}
  cloud:
    config:
      uri: http://localhost:8888/
      profile: dev            # profile对应config server所获取的配置文件中的{profile}
      label: master           # 指定Git仓库的分支，对应config server所获取的配置文件的{label}
  rabbitmq:
    host: localhost
    port: 5672
    username: admin
    password: admin

```

## 启动
启动完成后，可以通过`localhost:8889/refresh`完成对配置的动态刷新。


