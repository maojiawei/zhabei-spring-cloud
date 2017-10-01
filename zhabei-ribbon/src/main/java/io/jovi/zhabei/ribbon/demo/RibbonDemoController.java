package io.jovi.zhabei.ribbon.demo;/**
 * Created by jovi on 01/10/2017.
 */


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * All rights reserved. 2017-10-01 19:41
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
@RestController
public class RibbonDemoController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/addribbon")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("zhabei-client");
        // 打印当前选择的是哪个节点
        logger.info( serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
    }
}
