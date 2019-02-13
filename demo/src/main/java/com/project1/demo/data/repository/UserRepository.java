package com.project1.demo.data.repository;

import com.project1.demo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@Repository
//public interface UserRepository extends CrudRepository<User, Long> {
//}

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, String> {
}

//    CrudRepository provides CRUD functions
//    PagingAndSortingRepository provides methods to do pagination and sort records
//    JpaRepository provides JPA related methods such as flushing the persistence context and delete records in a batch
