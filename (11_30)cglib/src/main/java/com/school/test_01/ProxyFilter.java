package com.school.test_01;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class ProxyFilter implements CallbackFilter{

    public int accept(Method method) {
        if(method.getName().equals("update")){
            return 0;//此数值表示拦截的方法的顺序
        }else{
            return 1;
        }
    }
}
