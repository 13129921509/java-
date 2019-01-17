package com.ittx.springboot.proxy;

import com.ittx.springboot.server.MyAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private static Object target;
    private static MyAop myAop;

    public static Object getProxyInstance(Object object,MyAop myAop_){
        target = object;
        myAop = myAop_;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAop.begin();
                        Object returnValue = method.invoke(target,args);
                        myAop.commite();
                        return returnValue;
                    }
                }
        );
    }
}
