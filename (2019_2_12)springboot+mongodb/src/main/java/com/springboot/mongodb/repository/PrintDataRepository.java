package com.springboot.mongodb.repository;

import com.springboot.mongodb.entity.PrintData;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PrintDataRepository extends CrudRepository<PrintData,ObjectId> ,PagingAndSortingRepository<PrintData,ObjectId> {
}
