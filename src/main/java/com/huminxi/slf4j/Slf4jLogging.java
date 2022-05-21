package com.huminxi.slf4j;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
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
        log.trace("hello logging");
        log.debug("hello logging");
        log.info("hello logging");
        log.warn("hello logging");
        log.error("hello logging");

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // print logback's internal status
        StatusPrinter.print(lc);
    }
}
