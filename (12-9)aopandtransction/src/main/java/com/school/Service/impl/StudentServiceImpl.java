package com.school.Service.impl;

import com.school.Service.StudentService;
import com.school.dao.StudentDao;
import com.school.dao.impl.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.TransactionManager;
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void transcation(final int from,final int to) {
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//
//                studentDao.add(from);
//               // int i = 1/0;
//                studentDao.del(to);
//            }
//        });
        studentDao.add(from);
        int i = 1/0;
        studentDao.del(to);
    }
}
