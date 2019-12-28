package com.cai.chatroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Table(name = "user")
@Entity
@NoArgsConstructor
public class User {

    public static Map<String,String> DEFINE;

    public void define(){
        this.DEFINE = new HashMap<>();
        this.DEFINE.put("table","user");
        this.DEFINE.put("cache_key",DEFINE.get("table")+":"+this.id);
        this.DEFINE.put("createUser_cache_key",DEFINE.get("table")+":"+this.username);
    }
    @NotFound(action = NotFoundAction.IGNORE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String username;

    String password;

    String question;

    String answer;

    LocalDateTime created = LocalDateTime.now();

    Integer locked = 0;

}
