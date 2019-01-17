package com.ittx.springboot.Entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "tNAME")
    String name;

    @Column(name = "EMAIL")
    String email;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
