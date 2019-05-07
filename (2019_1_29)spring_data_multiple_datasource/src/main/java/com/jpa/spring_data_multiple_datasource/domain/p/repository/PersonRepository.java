package com.jpa.spring_data_multiple_datasource.domain.p.repository;

import com.jpa.spring_data_multiple_datasource.domain.p.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
