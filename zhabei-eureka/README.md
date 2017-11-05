# zhabei-eureka
Eureka主要作为spring cloud的服务发现模块，在spring cloud项目中需要第一个启动，后续项目均依赖于此。

## 项目依赖
项目继承了项目中的parent项目，可以直接使用eureka server。
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```

## 项目启动类
在项目启动类上添加`@EnableEurekaServer`注解，声明该项目为Eureka Server。
```
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
```
## 配置文件
server.port为项目端口，一般eureka的默认端口为8761.
eureka.client.registerWithEureka表示是否需要注册到Eureka Server，默认为true。本应用本身即为Eureka Server，所以为false。
eureka.client.fetchRegistry表示是否需要注册从Eureka Server中获取注册信息，默认为true。由于本例为单点的Eureka Server，不需要与其他Eureka Server节点进行数据同步，所以为false。

