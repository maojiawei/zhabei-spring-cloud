# zhabei-turbine
在复杂的分布式系统中，相同服务的节点经常需要部署上百甚至上千个，很多时候，运维人员希望能够把相同服务的节点状态以一个整体集群的形式展现出来，这样可以更好的把握整个系统的状态。 为此，Netflix提供了一个开源项目（Turbine）来提供把多个hystrix.stream的内容聚合为一个数据源供Dashboard展示。

## 项目依赖
1. turbine模块。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-turbine-stream</artifactId>
</dependency>
```

## 项目启动类
在项目启动类上添加`@EnableDiscoveryClient`注解，可以将服务注册至Eureka。  
在项目启动类上添加`@EnableTurbineStream`注解，默认为Turbine项目。  
```
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class TrubineServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrubineServerApplication.class, args);
    }
}
```


## 配置文件
server.port为项目端口。
spring.application.name为项目名称。
spring.rabbitmq.host为rabbitmq的host地址、port为端口、username为用户名、password为用户密码。
eureka.client.serviceUrl.serviceUrl为eureka的地址。
turbine.appConfig主要为监控的服务。
```
spring:
  application:
    name: hystrix-dashboard-turbine
  rabbitmq:
    host: localhost
    port: 5672
    username: admin
    password: admin
turbine:
  appConfig: zhabei-client, zhabei-feign
  aggregator:
    cluster-config: default
  clusterNameExpression: new String("default")
eureka:
  client:
    service-url:
      default-zone: http://localhost:8761/eureka/
server:
  port: 8097
```

## 启动
启动hystrix项目，并输入`localhst:8097/turbine.stream`,即可看到以下界面。  
![avatar](turbine.jpg)
