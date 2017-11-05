# zhabei-ribbon
Spring Cloud Ribbon 是一个基于Http和TCP的客服端负载均衡工具，它是基于Netflix Ribbon实现的。它不像服务注册中心、配置中心、API网关那样独立部署，但是它几乎存在于每个微服务的基础设施中。

## 项目依赖
1. spring-cloud针对ribbon项目的依赖。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-ribbon</artifactId>
</dependency>
```


## 项目启动类
在项目启动类上添加`@EnableDiscoveryClient`注解，可以将服务注册至Eureka。
`@LoadBalanced`为客户端负载均衡的需要。
```
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}
```

## 项目接口
RibbonDemoController为调用接口主要调用zhabei-client服务提供端。
`@GetMapping("/addribbon")`该方法为正常调用ribbon的方式（已包含负载均衡）。
`@GetMapping("/testload")`主要为了测试负载均衡，查看调用的节点。
```
@RestController
public class RibbonDemoController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/addribbon")
    public String addribbon(Integer c,Integer d) {
       return restTemplate.getForObject("http://zhabei-client/add?a="+c+"&b="+d,String.class);
    }

    @GetMapping("/testload")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("zhabei-client");
        // 打印当前选择的是哪个节点
        logger.info( serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
    }
}
```

## 配置文件
server.port为项目端口。
spring.application.name为项目名称。
eureka.client.serviceUrl.serviceUrl为eureka的地址
```
server:
  port: 8091
spring:
  application:
    name: zhabei-ribbon
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
```
