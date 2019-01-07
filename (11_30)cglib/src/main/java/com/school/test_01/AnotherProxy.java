package com.school.test_01;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;

public class AnotherProxy implements MethodInterceptor{
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("start:"+DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(new Date()));
        methodProxy.invokeSuper(o,objects);
        System.out.println("end:"+DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(new Date()));
        return null;
    }
}
