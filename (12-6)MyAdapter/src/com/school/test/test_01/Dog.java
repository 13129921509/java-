package com.school.test.test_01;

public class Dog implements WalkAnimal {

    @Override
    public void move() {
        System.out.println("我是狗，会走的");
    }
}
