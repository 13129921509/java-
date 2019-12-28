package com.cai.chatroom.base.genarate;

import lombok.Data;

@Data
public class ResponseMessage<T> {
    String status;
    String message;
    T data;
    boolean isSuccess;
    public static String ERROR_STATUS = "error";
    public static String SUCCESS_STATUS = "success";

    public ResponseMessage(String status, String message, T data, boolean isSuccess) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.isSuccess = isSuccess;
    }


    public ResponseMessage(String status, String message, boolean isSuccess) {
        this.status = status;
        this.message = message;
        this.isSuccess = isSuccess;
    }


    public ResponseMessage(String status, T data, boolean isSuccess) {
        this.status = status;
        this.data = data;
        this.isSuccess = isSuccess;
    }


    public ResponseMessage(String status) {
        this.status = status;
    }
}
