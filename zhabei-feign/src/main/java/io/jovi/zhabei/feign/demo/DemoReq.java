package io.jovi.zhabei.feign.demo;/**
 * Created by jovi on 01/10/2017.
 */

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * All rights reserved. 2017-10-01 21:48
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class DemoReq {

    private Integer c;

    private Integer d;

    public DemoReq(Integer c, Integer d) {
        this.c = c;
        this.d = d;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }
}
