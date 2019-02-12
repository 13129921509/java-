package com.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.springboot.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserMapper extends BaseMapper<User> {

    @Select("select version from user ${ew.customSqlSegment}")
    String getVersion(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Update("update from user ${ew.customSqlSegment}")
    String setVersion(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
