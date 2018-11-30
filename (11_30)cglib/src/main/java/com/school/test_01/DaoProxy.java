package com.school.test_01;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DaoProxy implements MethodInterceptor{

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("------------Before-------------");
        methodProxy.invokeSuper(o,objects);
        System.out.println("------------after-------------");
        return o;
    }
}
