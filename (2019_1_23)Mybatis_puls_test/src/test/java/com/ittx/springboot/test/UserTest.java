package com.ittx.springboot.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ittx.springboot.entity.User;
import com.ittx.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    User user;
    @Autowired
    UserMapper userMapper;
    @Test
    public void test_0(){
//        userMapper.getAll(Wrappers.<User>lambdaQuery().eq(new QueryWrapper<User>()::e));
    }
    public void insert(User user){
        userMapper.insert(user);
    }
    public void show(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    public void deleteMap(){
        insert(new User(Long.valueOf(100),"cai",21,"942445346@qq.com"));
        show();
        System.out.println("--------------------------------------------------------");
        Map map = new HashMap<String,Object>();
        map.put("age",21);
        map.put("email","test4@baomidou.com");
        userMapper.deleteByMap(map);
        show();
    }

    public void delete(){

        show();
        System.out.println("--------------------------------------------------------");
//        userMapper.delete(new AbstractWrapper<String, Object>.allEq((String k, Object v) -> k.indexOf("a")>1,{"id":1,"name":"老王"}));
        Map map = new HashMap<String,Object>();
        map.put("age",21);
        map.put("email","test4@baomidou.com");
        System.out.println(userMapper.delete(new QueryWrapper<User>().select("*").gt("id",3)));
        show();
    }
//select * form age>=18 and name like J%
    public void selectList(){
        System.out.println(userMapper.selectList(
                new QueryWrapper<User>()
                    .select("*")
                    .and(i -> i.ge("age","18"))
                    .and(i -> i.like("name","J%"))));
    }


}
