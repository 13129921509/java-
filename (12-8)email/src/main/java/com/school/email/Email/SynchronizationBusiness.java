package com.school.email.Email;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SynchronizationBusiness implements InvocationHandler{

    public static final Object lock = new Object();
    Object obj;
    public SynchronizationBusiness(Object obj){
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(Thread.currentThread().getName()+"准备执行!!!");
        //synchronized (lock){
        method.invoke(obj,args);
        //}
        return null;
    }
}
