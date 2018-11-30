package com.school.test_01;

import net.sf.cglib.proxy.Enhancer;

public class Test_01 {
    public static void main(String[] args) {
        DaoProxy daoProxy = new DaoProxy();
        AnotherProxy daoProxy2 = new AnotherProxy();
        Enhancer enhaner = new Enhancer();
        enhaner.setSuperclass(Dao.class);
        enhaner.setCallback(daoProxy);
        Dao dao = (Dao) enhaner.create();
        dao.update();
    }
}
