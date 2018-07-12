package com.kovacic.repository;

import com.kovacic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ikovacic.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u WHERE LOWER(u.email) = LOWER(:email)")
    User findByEmail(@Param("email") String email);


}
