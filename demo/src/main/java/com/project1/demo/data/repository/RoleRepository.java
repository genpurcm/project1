package com.project1.demo.data.repository;//package com.project1.demo.data.repository;

import com.project1.demo.data.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface RoleRepository extends JpaRepository<Role, String> {
}
