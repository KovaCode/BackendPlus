package com.kovacic.repository;

import com.kovacic.entity.Priviledges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface PriviledgesRepository extends JpaRepository<Priviledges, Long> {
    @Query("SELECT COUNT(s.id) FROM Priviledges s")
    long count();

}
