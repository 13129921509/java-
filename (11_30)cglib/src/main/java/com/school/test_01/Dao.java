package com.school.test_01;

public class Dao {
    public Dao(){
        update();
    }

    public void update(){
        System.out.println("到了update方法");
    }

    public void select(){
        System.out.println("到了select方法");
    }
}
