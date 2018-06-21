package com.kovacic.repository;

import com.kovacic.entity.SystemLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ikovacic.
 */
@Repository
public interface SystemLoginRepository extends JpaRepository<SystemLogin, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE system_login s SET s.logged = :looged WHERE c.id = :userId")
    int setLogged(@Param("looged") boolean login, @Param("userId") Long userId);


}
