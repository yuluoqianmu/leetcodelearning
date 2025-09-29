package com.shml.myAlgorithm;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SpringDynamicProxyDemo {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        ProxyFactory proxyFactory = new ProxyFactory(userService);
        proxyFactory.addAdvice(new LoggingInterceptor());

        UserService proxy = (UserService)proxyFactory.getProxy();
        proxy.save();
    }
}

class LoggingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        System.out.println("【前置通知】开始执行方法: " + methodName);

        // 执行原始方法
        Object result = invocation.proceed();

        System.out.println("【后置通知】方法执行完成: " + methodName);
        return result;
    }
}