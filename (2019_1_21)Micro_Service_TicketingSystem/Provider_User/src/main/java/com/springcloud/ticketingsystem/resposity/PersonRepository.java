package com.springcloud.ticketingsystem.resposity;

import com.springcloud.ticketingsystem.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PersonRepository extends CrudRepository<Person,Long> {
    @Query("select o from Person o")
    List<Person> getAll();

    @Modifying
    @Query("delete from Person o where o.name = :name")
    void deletePersonByName(@Param("name") String name);
}
