package com.school.email;

import com.school.email.Email.MailService;
import com.school.email.Email.MyEmail;
import com.school.email.Email.SynchronizationBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test_01 {
    public static final Object lock = new Object();
    @Autowired
    MyEmail myEmail;
    @Test
    public void test_01(){
//        ExecutorService executors = Executors.newCachedThreadPool();
//        for(int i = 0 ; i < 10 ; i++){
//            executors.execute(new Runnable() {
//                @Override
//                public void run() {
//                    synchronized (lock){
//                        //MailService service = (MailService) Proxy.newProxyInstance(MyEmail.class.getClassLoader(),MyEmail.class.getInterfaces(),new SynchronizationBusiness(myEmail) );
                        myEmail.sendSimpleMail("942445346@qq.com","注意查收","简单邮件");
//                   }
//                }
//            });
//        }
    }

//    @Test
//    public void test_02(){
//        MailService service = (MailService) Proxy.newProxyInstance(MyEmail.class.getClassLoader(),MyEmail.class.getInterfaces(),new SynchronizationBusiness(myEmail) );
//        service.sendSimpleMail("942445346@qq.com","注意查收","简单邮件");
//    }
}
