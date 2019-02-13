package com.project1.demo.data.repository;

import com.project1.demo.data.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
//public interface CrudRepository extends JpaRepository<User, Long> {
public interface CrudRepository extends JpaRepository<User, String> {

//    Page<User> findByfirstNameLike(String firstName, Pageable pageable);


    @Query("select u from User u where upper(u.firstName) like concat('%', upper(?1), '%') or upper(u.lastName) like concat('%', upper(?2), '%') or upper(u.emailAddress) like concat('%', upper(?3), '%')")
    Page<User> findByInPut(String name, String name2, String name3, Pageable pageable);
//    Page<User> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(String name, String name2, Pageable pageable);
}
