package com.school.springbootandmybatis.mapper;

import com.school.springbootandmybatis.entity.Student;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.jdbc.SQL;

public class StudentProvider{
    public String getStudent(String id,String name) {
        String s =  new SQL(){
           {
                SELECT("*").FROM("STUDENT");
                if(id != null){
                    WHERE("STUDENT_ID=#{id}");
                }
               if(name != null){
                   WHERE("STUDENT_NAME=#{name}");
               }
           }
       }.toString();
        System.out.println("SQL语句:"+s);
        return s;
    }

    public String insertStudent(String name){
        String s = new SQL(){
            {
                INSERT_INTO("STUDENT");
                if(name!=null){
                    VALUES("student_name","#{name}");
                }
            }
        }.toString();
        System.out.println("SQL语句:"+s);
        return s;
    }
}
