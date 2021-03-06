package com.project1.demo.data.repository;

import com.project1.demo.data.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(exported = false)
public interface Player2Repository extends JpaRepository<Player, Long> {



}
