package com.school.test_01;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class Test_01 {
    public static void main(String[] args) {
        DaoProxy daoProxy = new DaoProxy();
        AnotherProxy daoProxy2 = new AnotherProxy();
        Enhancer enhaner = new Enhancer();
        enhaner.setSuperclass(Dao.class);
        enhaner.setCallbacks(new Callback[]{daoProxy,daoProxy2, NoOp.INSTANCE});
        enhaner.setCallbackFilter(new ProxyFilter());
        enhaner.setInterceptDuringConstruction(false);
        Dao dao = (Dao) enhaner.create();
        dao.update();
        dao.select();
    }
}
