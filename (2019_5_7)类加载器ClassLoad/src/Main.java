
import com.test.ITest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        MyClassLoad myClassLoad = new MyClassLoad("e:\\home");
        Class clazz = myClassLoad.loadClass("com.test.Test");
        ClassLoader.getSystemClassLoader().loadClass("com.test.Test");

        System.out.println(clazz);
        System.out.println(Class.forName("com.test.Test").getDeclaredMethods());
//        Method test = clazz.getMethod("test",null);
        Method test = Class.forName("com.test.Test").getMethod("test",null);
        test.invoke(Class.forName("com.test.Test").newInstance(),null);
        /**
         * 产生一个需求 拦截本地的一个方法，改成另一个同名类的同名方法
         */
        ITest i = (ITest) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader().loadClass("com.test.Test").getClassLoader(),
                ClassLoader.getSystemClassLoader().loadClass("com.test.Test").getInterfaces(),
                new java.lang.reflect.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return clazz.getMethod("test",null).invoke(clazz.newInstance(),null);
                    }
                });
        i.test();

    }
}
