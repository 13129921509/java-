package com.school.springboot.test;

import com.school.springboot.bean.Emploey;
import com.school.springboot.dao.EmployeDao;
import com.school.springboot.mapper.ComplexEmployeMapper;
import com.school.springboot.mapper.EmploeyMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@MapperScan(basePackages = "com.school.springboot.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
    @Autowired
    private EmployeDao employeDao;

    @Autowired
    private EmploeyMapper mapper;

    @Autowired
    SqlSession sqlSession;
    @Test
    public void test_01(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
//        employeDao.save(new Emploey("chejian","nv"));
//        employeDao.save(new Emploey("chejian2","n2"));
//        employeDao.save(new Emploey("chejian3","nv3"));
        //Emploey e = employeDao.findById(6).get();
        //System.out.println(e.getSex());
       // Assert.assertEquals(133,employeDao.findAll().size());
        Emploey e = employeDao.findById(5).get();
        e.setSex("kk");
        employeDao.save(e);
    }


    @Test
    public void test_02(){
        System.out.println("男性的人数"+employeDao.getEmploeyBySex("nan").get(0));
    }
    /*
        以下使用mybatis操作
     */
    @Test
    public void test_03(){
        for(int i = 0 ; i<mapper.getAll().size();i++){
            System.out.println("姓名:"+mapper.getAll().get(i).getUserName());
        }
    }

    @Test
    public void test_04(){
        for(int i = 0 ; i<mapper.getUsersByParamName("cai").size();i++){
            System.out.println("姓名:"+mapper.getAll().get(i).getUserName());
        }
    }

    @Test
    public void test_05(){
        Map map = new HashMap<>();
        map.put("sex","nan");
        for(int i = 0; i<mapper.getUsersByParamNameOrSex(map).size(); i++){
            System.out.println("姓名:"+mapper.getAll().get(i).getUserName());
        }
    }

    //使用ibatis提供的sql语句构建器操作
    @Test
    public void test_06(){
        mapper.deleteByCondition(10,null,null);

    }
}
