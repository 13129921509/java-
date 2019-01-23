package interper;

import rule.TimeRuler;
import rule.inf.Ruler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public class ObserverInterper implements InvocationHandler {
    Object object;
    Ruler ruler;
    AtomicBoolean status;
    public ObserverInterper(Object object){
        this.object = object;
        status = new AtomicBoolean(true);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final Object[] result = {new Object()};
        ruler = new TimeRuler(Long.valueOf(1));
        Thread t = new Thread(ruler);
        t.setDaemon(true);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    result[0] = method.invoke(object,args);
                    status.set(false);
                    ruler.setStatus(status.get());//任务完成 则改变状态
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
        /**
         * 当等待时间超过预期 则强行中断任务
         */
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!ruler.isEndStatus()){
                }
                t2.interrupt();
            }
        });
        t.join();
        t2.join();
        t3.join();
        t.start();
        t2.start();
        t3.start();
        if(ruler.isEndStatus()){
            return result[0];
        }else{
            return null;
        }
    }
}
