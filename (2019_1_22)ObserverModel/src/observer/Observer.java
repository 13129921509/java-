package observer;

//import observer.inf.Obserber;
import observer.inf.ObserberInf;
import subject.Subjcet;
/**
 * 使用遍历的方式是不可取的，假设一个节点意外堵塞，接下来的节点都会因此产生堵塞，提供以下几个方法
 * 1.使用堵塞队列+线程池的方式（最佳方案）
 * 2.采用List+线程池的方式
 * 3.到达指定时间，变丢弃任务
 * @throws InterruptedException
 */
/**
 * 构成
 * 1.观察者：观察者通常伴随着不同的事件触发，非常耗时
 * 2.对象：被观察的对象，通常被多个观察者观察
 * 3.拦截器：对观察者的观察进行拦截，作为系统对观察句柄的介入
 * 4.裁判：对观察者的记录，掌握他们的出局于否
 * @throws InterruptedException
 */
public abstract class Observer {
    private Subjcet subjcet;



}
