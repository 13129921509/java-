package com.springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "user")
public class User {
    @TableId(value = "id")
    Integer id;

    @TableField(value = "name")
    String name;

    @TableField(value = "version")
    String version;

    public User() {
    }
}
