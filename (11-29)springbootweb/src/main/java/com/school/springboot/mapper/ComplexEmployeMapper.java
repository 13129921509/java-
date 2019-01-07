package com.school.springboot.mapper;

import com.school.springboot.bean.Emploey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class ComplexEmployeMapper {

    //以下为sql语句构建器
    public String deleteByCondition(final Integer id,final String sex,final String username){
        return new SQL(){
            {
                DELETE_FROM("emploeytable");
                if(null != id){
                    WHERE("ID= #{id}");
                }
                if(null != sex){
                    WHERE("Sex= #{sex}");
                }
                if(null != username){
                    WHERE("User_Name= #{username}");
                }
            }
        }.toString();
    }
}
