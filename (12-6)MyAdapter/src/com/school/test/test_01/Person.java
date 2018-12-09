package com.school.test.test_01;

public class Person implements WalkAnimal{
    @Override
    public void move() {
        System.out.println("我是人，会走的");
    }
}
