# zhabei-feign
Feign是一种声明式、模板化的HTTP客户端。在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验，开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。

## 项目依赖
1. spring-cloud针对Eureka项目的依赖。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```
2. spring-boot-starter-actuator这个库让我们可以访问应用的很多信息，包括：/env、/info、/metrics、/health等。
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
3. feign的项目依赖。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```
4. hystrix的项目依赖。hystrix主要为spring cloud中的熔断机制。  
在微服务架构中通常会有多个服务层调用，基础服务的故障可能会导致级联故障，进而造成整个系统不可用的情况，这种现象被称为服务雪崩效应。服务雪崩效应是一种因“服务提供者”的不可用导致“服务消费者”的不可用,并将不可用逐渐放大的过程。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```
5. hystrix的项目依赖，可以将数据传输到hystrix的dashboard中。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-netflix-hystrix-stream</artifactId>
</dependency>
```
6. 引入rabbitmq的依赖。用于传输数据。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
</dependency>
```
4. spring-cloud-sleuth的一个模块。主要可以为zhabei-zipkin项目提供数据，将服务调用信息传递给zipkin。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-stream</artifactId>
</dependency>
```

## 项目启动类
在项目启动类上添加`@EnableDiscoveryClient`注解，可以将服务注册至Eureka。
```
@EnableHystrix
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
```

## 项目接口
1. DemoFeignClient
标准的feign消费端  
`@FeignClient(name = "zhabei-client")`表示服务调用的服务提供端。
```
@FeignClient(name = "zhabei-client")
public interface DemoFeignClient {
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer addfeign(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
```
2. DemoFeignController
带断路器的feign消费端  
`@HystrixCommand(fallbackMethod = "addFallback")` HystrixCommand表示当服务提供端异常时的回调方法
```
@RestController
public class DemoFeignController {
    @Autowired
    private DemoFeignClient client;

    @GetMapping("/aaa/add")
    @HystrixCommand(fallbackMethod = "addFallback")
    public Integer add(Integer c,Integer d){

        return client.addfeign(c, d);
    }

    public Integer addFallback(Integer c,Integer d){
        return 0;
    }
}
```
## 配置文件
server.port为项目端口。
spring.application.name为项目名称。
spring.rabbitmq.host为rabbitmq的host地址、port为端口、username为用户名、password为用户密码。
eureka.client.serviceUrl.serviceUrl为eureka的地址
```
server:
  port: 8092
spring:
  application:
    name: zhabei-feign
  rabbitmq:
      host: localhost
      port: 5672
      username: admin
      password: admin
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
```
