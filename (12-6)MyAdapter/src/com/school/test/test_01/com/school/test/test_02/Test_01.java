package com.school.test.test_01.com.school.test.test_02;

/**
 * 适配器模式
 * 如果想扩展主体类的功能，就在主类中设置一个扩展功能适配器，然后一起继承一个接口，让主类与适配器类实现它
 * 接口的用处就是规范两个类之间的关联，实现的方法就是扩展的功能
 * 就比如电脑的存储系统，原来只有硬盘，现在扩展出移动硬盘和U盘
 * 那么主类的扩展方法便是有3个方法（硬盘，移动硬盘，U盘）
 * 适配器类的方法便是有2个方法（移动硬盘，U盘）
 * 解决以下问题
 * 假设动物有两种移动方法：飞的（暂缺） 跑的
 * 飞的 有鹰 蝴蝶
 * 跑的 有人 有狗
 * 现在设计适配器 让飞的加入主类
 */
public class Test_01 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        Object obj = new Person();
//        System.out.println(obj.getClass().getName());
        AnimalAction animalAction  = new AnimalAction();
        //animalAction.readName("狗");
        /**
         * readName2方法用类的class机制也可以做到适配器的工作
         */
        animalAction.readName2(Eagle.class);
    }
}
