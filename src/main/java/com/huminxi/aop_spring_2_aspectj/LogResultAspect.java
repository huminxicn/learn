package com.huminxi.aop_spring_2_aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/11 14:22
 */
@Aspect
public class LogResultAspect {
    private boolean trace;

    @AfterReturning(pointcut = "com.huminxi.aop_spring_2_aspectj.SystemArchitecture.businessService()",
            returning = "result")
    public void logResult(Object result) {
        if (trace) {
            System.out.println("[@AspectJ]返回值：" + result);
        }
    }

    public void setTrace(boolean trace) {
        this.trace = trace;
    }
}
