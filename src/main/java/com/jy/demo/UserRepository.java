package com.jy.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.firstName = :firstName WHERE user.id = :id")
    int updateFirstName(@Param("id") long id, @Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.lastName = :lastName WHERE user.id = :id")
    int updateLastName(@Param("id") long id, @Param("lastName") String lastName);
}