package com.springboot.mongodb.domain;

import com.springboot.mongodb.inter.WriterException;

public class ExceptionResponse {
    private String printStackTrace;
    private String dataTime;
    private String clazz;
    private String expireAt;

    public String getPrintStackTrace() {
        return printStackTrace;
    }

    public void setPrintStackTrace(String printStackTrace) {
        this.printStackTrace = printStackTrace;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    public ExceptionResponse(WriterException write, String dataTime, String clazz, String expireAt) {
        this.printStackTrace = write.write();
        this.dataTime = dataTime;
        this.clazz = clazz;
        this.expireAt = expireAt;
    }
}


