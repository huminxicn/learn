package com.huminxi.aop_spring_2_aspectj;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/11 14:23
 */
public class SystemArchitecture {

    @Pointcut("within(com.huminxi.web..*)")
    public void inWebLayer(){}

    @Pointcut("within(com.huminxi.service..*)")
    public void inServiceLayer(){}

    @Pointcut("execution(* com.huminxi.service.*.*(..))")
    public void businessService(){}
}
