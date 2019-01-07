package com.school.test.test_01;
//用来扩展飞行功能
public class FlyAdaper implements AnimalUtils {
    @Override
    public FlyAnimal readName(String animalName) {
        if("鹰".equals(animalName)){
            return new Eagle();
        }else if("蝴蝶".equals(animalName)){
            return new Butterfly();
        }
        return null;
    }
}
