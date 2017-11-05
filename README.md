# spring cloud
本文主要为spring cloud学习项目，主要提供spring cloud的学习。

## 开发环境准备
1.java 1.8+  
2.Maven 3+  
3.IDEA 2016+  
 
## 项目应用准备
1.rabbitmq


## 项目说明
均为标准SpringBoot构建项目，可使用`mvn spring-boot:run -Dserver.port=[port]`形式进行启动。或者在package打包后使用java -jar xxx.jar形式。
### zhabei-parent
parent项目主要负责针对项目jar包的版本管理。

### zhabei-eureka
Eureka主要作为spring cloud的服务发现模块，在spring cloud项目中需要第一个启动，后续项目均依赖于此。

### zhabei-client
项目主要为spring cloud客户端，也可以称为服务提供端(provider)。spring cloud主要采用restful方式提供服务。

### zhabei-client-back
项目与zhabei-client项目相同。

### zhabei-ribbon
Ribbon主要为spring cloud服务端，也可以称为消费端(consume)。

### zhabei-feign
Feign是一种声明式、模板化的HTTP客户端，针对ribbon的封装，主要为spring cloud服务端，也可以称为消费端(consume)。

### zhabei-hystrix-dashboard
Hystrix在spring cloud中主要作为断路器，该项目可以提供对于spring cloud的服务监控。

### zhabei-turbine
Turbine可以帮助我们把所有的服务实例的监控信息聚合到一个地方统一查看。

### zhabei-zipkin
Zipkin可以查看微服务各模块之间的调用关系。

### zhabei-config-server
该项目为spring cloud项目的配置中心的服务端。

### zhabei-config-client
该项目为spring cloud项目的配置中心的客户端。

### zhabei-zuul
zuul主要为项目的API网关。



