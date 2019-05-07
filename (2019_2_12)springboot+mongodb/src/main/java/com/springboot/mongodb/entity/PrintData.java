package com.springboot.mongodb.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "print_data")
public class PrintData {
    @Id
    public ObjectId id;

    @Field("created")
    public String created;

    @Field("printData")
    public String printDate;

    @Field("expireAt")
    public String expireAt;


    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPrintDate() {
        return printDate;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    public PrintData(ObjectId id, String created, String printDate, String expireAt) {
        this.id = id;
        this.created = created;
        this.printDate = printDate;
        this.expireAt = expireAt;
    }
}
