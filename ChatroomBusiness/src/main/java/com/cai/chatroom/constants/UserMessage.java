package com.cai.chatroom.constants;

public class UserMessage {
    public static String UM_0001 = "帐号不存在";
    public static String UM_0002 = "密码错误";
    public static String UM_0003 = "该账号已登录";
    public static String UM_0004(String ...args){
        return UM_0003+":"+args[0];
    }  //"该账号已登录:001";
    public static String UM_0005 = "用户已存在";
    public static String UM_0006 = "用户名不能为空";
    public static String UM_0007 = "该对象无法注册";
}
