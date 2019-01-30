package com.springcloud.ticketingsystem.entity;

public class User{
    String name;
    String age;
//    public User(String name, String age) {
//        this.name = name;
//        this.age = age;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

   public User withName(String name){
        this.setName(name);
        return this;
    }

    public User withAge(String age){
        this.setAge(age);
        return this;
    }
}
