package com.cai.chatroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRecord implements Serializable {

    public ChatRecord(String form, LocalDateTime created, String path) {
        this.form = form;
        this.created = created;
        this.path = path;
    }

    public ChatRecord(String form, String path) {
        this.form = form;
        this.created = LocalDateTime.now();
        this.path = path;
    }

    @NotFound(action = NotFoundAction.IGNORE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String form;

    LocalDateTime created;

    String path;


}
