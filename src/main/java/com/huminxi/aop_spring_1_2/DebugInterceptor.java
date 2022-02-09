package com.huminxi.aop_spring_1_2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/09 16:21
 */
public class DebugInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before:invocation=[" + invocation + "]");
        //执行 真实实现类 的方法
        Object result = invocation.proceed();
        System.out.println("Invocation return");
        return result;
    }
}
