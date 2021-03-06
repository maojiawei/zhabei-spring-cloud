package io.jovi.zhabei.turbine;/**
 * Created by jovi on 02/10/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * All rights reserved. 2017-10-02 16:57
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class TrubineServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrubineServerApplication.class, args);
    }
}
