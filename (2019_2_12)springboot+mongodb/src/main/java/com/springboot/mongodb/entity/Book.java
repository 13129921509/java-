package com.springboot.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cai")
public class Book {
//    @Id
//    @Field("_Id")
//    private Long id;
    @Field("title")
    private String title;
    @Field("by")
    private String by;
    @Field("tags")
    private String tags;
    @Field("likes")
    private String likes;

    public Book(String title, String by, String tags, String likes) {
        this.title = title;
        this.by = by;
        this.tags = tags;
        this.likes = likes;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
