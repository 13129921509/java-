package com.ittx.springboot.explain;

import com.ittx.springboot.annotation.After;
import com.ittx.springboot.annotation.Before;
import com.ittx.springboot.annotation.Pointcut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AspectExplain {
    Method invokeMethod;//需要执行的方法
    Object obj;
    Method pointcutMethod;//切面方法的实例
    String pointcutMethodString;
    String pointcutClassString;
    Pointcut pointcut;
    Before before;
    After after;
    Object newInstance;//切面类的实例
    public AspectExplain(Object obj,Method invokeMethod){
        this.obj = obj;
        this.invokeMethod = invokeMethod;
    }

    public Pointcut getPointcut() throws Exception {
        try{
            for(Method method : obj.getClass().getDeclaredMethods()){
                Pointcut pointcut = method.getAnnotation(Pointcut.class);
                if(pointcut == null){
                    continue;
                }else{
                    this.setPointcut(pointcut);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void getBefore() throws Exception {
        try{
            for(Method method : obj.getClass().getDeclaredMethods()){
                Before before = method.getAnnotation(Before.class);
                if(before == null){
                    continue;
                }else{
                    this.setBefore(before);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 执行之前的准备工作
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public void beforeInvoke() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String value = pointcut.value();
        pointcutMethodString = pointcut.value().split("\\.")[pointcut.value().split("\\.").length-1];
        pointcutClassString = value.replace(pointcutMethodString,"");
        Class<?> cls = Class.forName(pointcutClassString.substring(0,pointcutClassString.length()-1));
        this.newInstance = cls.newInstance();
        pointcutMethod = newInstance.getClass().getMethod(pointcutMethodString);
    }

    public void invoke() throws Exception {
        beforeInvoke();
        if(before != null && after!=null){
            throw new Exception("无法同时执行两个通知");
        }else{
            if(before!=null){
                pointcutMethod.invoke(newInstance,null);
                invokeMethod.invoke(obj,null);
            }else{
                invokeMethod.invoke(obj,null);
                pointcutMethod.invoke(newInstance,null);
            }
        }
    }


    public void getAfter() {
        try{
            for(Method method : obj.getClass().getDeclaredMethods()){
                After after = method.getAnnotation(After.class);
                if(after == null){
                    continue;
                }else{
                    this.setAfter(after);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void isNull(Object object) throws Exception {
        if(object instanceof Object){
        }else{
            throw new Exception("没有"+object.getClass().getName());
        }
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setBefore(Before before) {
        this.before = before;
    }

    public void setAfter(After after) {
        this.after = after;
    }
}
