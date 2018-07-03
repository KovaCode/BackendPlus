package com.kovacic.repository;

import com.kovacic.entity.Priviledges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriviledgesRepository extends JpaRepository<Priviledges, Long> {

    @Query("SELECT COUNT(s.id) FROM Priviledges s")
    long count();

}
