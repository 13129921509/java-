package com.school.test_01;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.DateFormat;

public class AnotherProxy implements MethodInterceptor{
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("start:"+DateFormat.getDateInstance());
        methodProxy.invokeSuper(o,objects);
        System.out.println("end:"+DateFormat.getDateInstance());
    }
}
