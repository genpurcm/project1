package com.project1.demo.data.repository;

import com.project1.demo.data.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}

//@Repository
//public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
//}


//    CrudRepository provides CRUD functions
//    PagingAndSortingRepository provides methods to do pagination and sort records
//    JpaRepository provides JPA related methods such as flushing the persistence context and delete records in a batch
