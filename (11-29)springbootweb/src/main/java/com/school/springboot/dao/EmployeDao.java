package com.school.springboot.dao;

import com.school.springboot.bean.Emploey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeDao extends JpaRepository<Emploey,Integer>{
    Emploey findByUserName(String userName);
    Emploey findByUserNameOrId(String id,String userName);

    @Modifying
    @Query("select count(e.id) from Emploey as e where e.sex=?1")
    List getEmploeyBySex(String sex);

}
