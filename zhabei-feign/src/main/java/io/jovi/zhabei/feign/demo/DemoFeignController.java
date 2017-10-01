package io.jovi.zhabei.feign.demo;/**
 * Created by jovi on 01/10/2017.
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * All rights reserved. 2017-10-01 21:39
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
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
