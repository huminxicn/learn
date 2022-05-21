package com.huminxi.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/05/21 23:16
 */
public class Slf4jLogging {
    private static Logger log = LoggerFactory.getLogger(Slf4jLogging.class);

    public static void main(String[] args) {
        log.info("hello logging");
    }
}
