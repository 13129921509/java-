package com.school.springboot.mapper;

import com.school.springboot.bean.Emploey;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface EmploeyMapper {
    @Select("Select User_Name,Sex from emploeytable")
    @Results({
            @Result(property = "userName",column = "User_Name",javaType = String.class),
            @Result(property = "sex",column = "Sex",javaType = String.class)
        })
    List<Emploey> getAll();


    @Select("Select User_Name,Sex from emploeytable where User_Name like '%'#(name)'%'")
    @Results({
            @Result(property = "userName",column = "User_Name",javaType = String.class),
            @Result(property = "sex",column = "Sex",javaType = String.class)
    })
    List<Emploey> getUsersByParamName(@Param("name") String name);

    //只能做一些简单的动态SQL，不要对这种方式抱有太大的希望
    //复杂的动态SQL老实地采用sql语句构建器
    @Select("<script>\n" +
            "Select User_Name,Sex from emploeytable WHERE" +
            "<if test='sex!=null'>Sex = #{sex}</if>"
            +"</script>")
    @Results({
            @Result(property = "userName",column = "User_Name",javaType = String.class),
            @Result(property = "sex",column = "Sex",javaType = String.class)
    })
    List<Emploey> getUsersByParamNameOrSex(Map<String,Object> map);

    @SelectProvider(type = ComplexEmployeMapper.class,method = "deleteByCondition")
    String deleteByCondition(@Param("id") Integer id,@Param("sex") String sex,@Param("username") String username);
}
