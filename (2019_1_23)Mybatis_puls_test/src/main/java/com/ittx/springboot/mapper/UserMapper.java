package com.ittx.springboot.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittx.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends BaseMapper<User> {
   // void getAll(LambdaQueryWrapper<User> val);

    @Select(value = "select * from user ${ew.customSqlSegment}")
    List<User> getAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Select(value = "select count(id) from user ${ew.customSqlSegment}")
    List<User> getAllByGroup(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Select("select * from user ${ew.customSqlSegment}")
    List<User> selectUserPage(Page<User> page,@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
