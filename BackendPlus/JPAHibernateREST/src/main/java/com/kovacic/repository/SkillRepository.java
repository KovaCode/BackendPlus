package com.kovacic.repository;

import com.kovacic.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ikovacic.
 */
@RepositoryRestResource(exported = false)
public interface SkillRepository extends JpaRepository<Skill, Long> {
    @Query("SELECT COUNT(s.id) FROM Skill s")
    long count();

    @Query("SELECT s FROM Skill s WHERE LOWER(s.name) = LOWER(:name)")
    Skill findByName(@Param("name") String name);

}
