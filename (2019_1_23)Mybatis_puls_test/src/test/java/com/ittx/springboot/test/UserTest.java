package com.ittx.springboot.test;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        //select();
//        updateBySetSql();
//        getAllBySql();
        userPage();
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

    public void select(){
//        show();
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.setEntity(user);
        wrapper.select(i->i.getProperty().startsWith("sex") );
    }

    public void update(){
        int update = userMapper.update(user, new UpdateWrapper<>(user).set("name", "cai").eq("name","Jone"));
        show();
    }

    public void updateBySetSql(){
        int update = userMapper.update(user, new UpdateWrapper<>(user).setSql("set name='k',age='22',email='111111@qq.com'").eq("name","Jone"));
        show();
    }

    //自定义sql
    public void getAllBySql(){
        show();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        List<User> list = userMapper.getAllByGroup(wrapper.between(User::getAge,20,24).groupBy(User::getAge));
        System.out.println(list);
    }

    //分页
    public void userPage(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        Page<User> page = new Page<>(1,1);
        page.setCurrent(2);
        List<User> list = userMapper.selectUserPage(page,wrapper.eq(User::getAge,20));
        System.out.println(list);
    }
}
