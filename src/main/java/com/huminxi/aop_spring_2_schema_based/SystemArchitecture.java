package com.huminxi.aop_spring_2_schema_based;

import org.aspectj.lang.annotation.Pointcut;

public class SystemArchitecture {

    @Pointcut("within(com.huminxi.web..*)")
    public void inWebLayer() {
    }

    @Pointcut("within(com.huminxi.service..*)")
    public void inServiceLayer() {
    }

    @Pointcut("execution(* com.huminxi.service.*.*(..))")
    public void businessService() {
    }

}
