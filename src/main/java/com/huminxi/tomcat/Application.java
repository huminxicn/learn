package com.huminxi.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 17:10
 */
public class Application {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        Connector connector = new Connector("HTTP/1.1");
        connector.setPort(8080);
        tomcat.setConnector(connector);

        tomcat.start();
        tomcat.getServer().await();
    }
}
