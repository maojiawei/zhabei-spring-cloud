package io.jovi.zhabei.feign.demo;/**
 * Created by jovi on 01/10/2017.
 */

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * All rights reserved. 2017-10-01 21:33
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
@FeignClient(name = "zhabei-client")
public interface DemoFeignClient {

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer addfeign(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
