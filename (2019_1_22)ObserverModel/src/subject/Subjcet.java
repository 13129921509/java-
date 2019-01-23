package subject;

import interper.ObserverInterper;
import observer.CaiObserver;
import observer.Observer;
import observer.ZhangObserver;
import observer.inf.ObserberInf;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Subjcet {
    private List<Observer> list = new ArrayList<Observer>();
    private ObserverInterper interper;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) throws InterruptedException {
        this.status = status;
        for(Observer observer : list){
            ObserberInf obj = (ObserberInf) Proxy.newProxyInstance(observer.getClass().getClassLoader(), observer.getClass().getInterfaces(), new ObserverInterper(observer));
            obj.update();
        }
    }

    public void attch(Observer observer){
        list.add(observer);
    }

    public static void main(String[] args) throws InterruptedException {
        Subjcet subjcet = new Subjcet();
        new CaiObserver(subjcet);
        new ZhangObserver(subjcet); new CaiObserver(subjcet);
        new ZhangObserver(subjcet);
        subjcet.setStatus(12);

    }
}
