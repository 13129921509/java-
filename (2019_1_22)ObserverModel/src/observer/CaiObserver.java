package observer;

import observer.inf.ObserberInf;
import subject.Subjcet;

public class CaiObserver extends Observer  implements ObserberInf {
    Subjcet subjcet;
    public CaiObserver(Subjcet subjcet) {
        this.subjcet = subjcet;
        this.subjcet.attch(this);
    }

    @Override
    public void update() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(this.getClass()+":"+subjcet.getStatus());
    }
}
