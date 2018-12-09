package com.school.test.test_01.com.school.test.test_02;

import javax.sql.DataSource;

//此类的原始功能只能输出能走的动物的信息
public class AnimalAction{
    FlyAdaper flyAdaper = new FlyAdaper();
    public void readName(String animalName) {// 输入animal的名称来输出信息
        if("人".equals(animalName)){
            WalkAnimal animal = new Person();
            animal.move();
        }if("狗".equals(animalName)){
            WalkAnimal animal = new Dog();
            animal.move();
        }
        else if("鹰".equals(animalName)||"蝴蝶".equals(animalName)){
            FlyAnimal animal = flyAdaper.readName(animalName);
            animal.move();
        }
    }

    public void readName2(Class AnimalClass) throws IllegalAccessException, InstantiationException {// 输入animal的class类型输出信息
        Animal animal;
        if((animal = (Animal) AnimalClass.newInstance()) instanceof WalkAnimal){
            animal.move();
        }else if((animal = (Animal) AnimalClass.newInstance()) instanceof FlyAnimal){
            animal.move();
        }
    }
}
