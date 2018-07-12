package com.kovacic.repository;

import com.kovacic.entity.SystemLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ikovacic.
 */
@RepositoryRestResource
public interface SystemLoginRepository extends JpaRepository<SystemLogin, Long> {

//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE system_login s SET s.logged = :logged WHERE s.userId = :userId")
//    int setLogged(@Param("logged") boolean login, @Param("userId") Long userId);
}
