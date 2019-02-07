package com.project1.demo.data.repository;

import com.project1.demo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
//public interface CrudRepository extends JpaRepository<User, Long> {
public interface CrudRepository extends JpaRepository<User, String> {
}
