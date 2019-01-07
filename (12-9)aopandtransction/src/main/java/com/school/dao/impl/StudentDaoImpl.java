package com.school.dao.impl;

import com.school.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import javax.transaction.TransactionManager;

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao{

    public void del(int id) {
        super.getJdbcTemplate().update("update student set student.student_id = student.student_id +100 where student.student_id=?",id);
    }

    public void add(int id) {
        super.getJdbcTemplate().update("update student set student.student_id = student.student_id -100 where student.student_id=?",id);

    }
}
