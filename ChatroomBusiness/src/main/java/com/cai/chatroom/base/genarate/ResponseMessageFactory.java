package com.cai.chatroom.base.genarate;

public class ResponseMessageFactory {
    public static ResponseMessage success(){
        return new ResponseMessage(ResponseMessage.SUCCESS_STATUS,null,true);
    }

    public static ResponseMessage success(String msg,Object data){
        return new ResponseMessage(ResponseMessage.SUCCESS_STATUS,msg,data,true);
    }

    public static ResponseMessage success(String msg){
        return new ResponseMessage(ResponseMessage.SUCCESS_STATUS,msg,true);
    }

    public static ResponseMessage error(String msg){
        return new ResponseMessage(ResponseMessage.ERROR_STATUS,msg,false);
    }
}
