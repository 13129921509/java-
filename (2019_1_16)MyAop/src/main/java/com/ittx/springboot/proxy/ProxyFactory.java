package com.ittx.springboot.proxy;

import com.ittx.springboot.annotation.Aspect;
import com.ittx.springboot.explain.AspectExplain;
import com.ittx.springboot.inface.IUserDao;
import com.ittx.springboot.server.MyAop;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Aspect
public class ProxyFactory {
    private static Object target;

    public static Object getProxyInstance(Object object){
        target = object;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Class<?> clazz = object.getClass();
                        Class<?>[] interfaces = clazz.getInterfaces();
                        AspectExplain aspectExplain = null;
                        for(Annotation anno : clazz.getAnnotations()){
                            if(anno instanceof com.ittx.springboot.annotation.Aspect){
                                aspectExplain = new AspectExplain(object,method);
                            }
                        }

                        for(Method method1 : clazz.getMethods()){
                            for(Annotation annotation : method1.getAnnotations()){
                                if(annotation instanceof com.ittx.springboot.annotation.Pointcut){
                                   aspectExplain.getPointcut();
                                }

                            }
                        }
                        method = object.getClass().getMethod(method.getName());
                        for(Annotation annotation:method.getAnnotations()){
                            if(annotation instanceof com.ittx.springboot.annotation.Before){
                                aspectExplain.getBefore();
                            }
                            if(annotation instanceof com.ittx.springboot.annotation.After){
                                aspectExplain.getAfter();
                            }
                        }
                        aspectExplain.invoke();
                        return null;
                    }
                }
        );
    }
}
