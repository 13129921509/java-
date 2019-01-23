package observer;

import observer.inf.ObserberInf;
import subject.Subjcet;

public class ZhangObserver extends Observer  implements ObserberInf {
    Subjcet subjcet;
    public ZhangObserver(Subjcet subjcet) {
        this.subjcet = subjcet;
        this.subjcet.attch(this);
    }


    @Override
    public void update() {
        System.out.println(this.getClass()+":"+subjcet.getStatus());
    }
}
