package com.school.springboot.bean;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "emploeytable")
public class Emploey implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;
    @Column(nullable = false,name = "User_Name")//@Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false,name = "Sex")
    private String sex;

    public Emploey(Integer id,String userName, String sex) {
        this.userName = userName;
        this.sex = sex;
        this.id=id;
    }

    public Emploey(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
