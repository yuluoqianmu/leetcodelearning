package com.shml.myAlgorithm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaDynamicProxy {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                handler);
        proxy.save();
    }
}

interface UserService {
    void save();
}

class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存用户");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知");
        Object result = method.invoke(target, args);
        System.out.println("后置通知");
        return result;
    }
}


