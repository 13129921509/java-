package com.school.myadvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvice2 {
    MyAdvice2(){

    }
    @Before("execution(* com.school.Service.impl.*Impl.*(..))")
    public void before(){
        System.out.println("方法调用之前");
    }

    public void after_Return(){
        System.out.println("方法调用之后(如果出现异常不会调用)");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("这是环绕通知之前的部分!!");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("这是环绕通知之后的部分!!");
        return obj;
    }

    //异常通知
    public void afterException(){
        System.out.println("出事啦!出现异常了!!");
    }
    //后置通知
    public void after(){
        System.out.println("这是后置通知(出现异常也会调用)!!");
    }
}
