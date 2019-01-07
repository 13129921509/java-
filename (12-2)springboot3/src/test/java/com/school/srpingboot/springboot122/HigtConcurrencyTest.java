package com.school.srpingboot.springboot122;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HigtConcurrencyTest {
    @Resource(name = "MyDataSource")
    DataSource dataSource;
    Connection connection;
    static CountDownLatch latch = new CountDownLatch(2000);
    public void get(){

            String sql="SELECT * FROM TB_BOOK WHERE BOOK_AUTHOR LIKE '曹%雪%芹' AND BOOK_PUBLISER ='天津古籍出版社'";
            try {
                System.out.println(Thread.currentThread().getName()+"已经准备好了");
                latch.await();
                synchronized (latch){
                    long start = System.currentTimeMillis();
                    connection = dataSource.getConnection();
                    ResultSet resultSet = connection.createStatement().executeQuery(sql);
                    resultSet.next();
                    String id=resultSet.getString(2);
                    System.out.println(Thread.currentThread().getName()+":"+id);
                    long end = System.currentTimeMillis();
                    System.out.println("花费:"+(start-end)+"ms");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }

    }

    @Test
    public void test_01() throws InterruptedException {
       /* ExecutorService executors = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 1000 ; i++){
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    get();
                }
            });
        }*/
        for(int i = 0 ; i < 2000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    get();
                }
            }).start();
            latch.countDown();
        }
        Thread.currentThread().sleep(10000);
    }
}
