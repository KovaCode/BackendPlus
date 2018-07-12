package com.kovacic.repository;

import com.kovacic.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ikovacic.
 */
@RepositoryRestResource(exported = false)
public interface ProfileRepository extends JpaRepository<Profile, Long> {

//    @Query("SELECT p FROM profile p WHERE p.id = (select up.id_profile from user_profile up where up.id_user=:id)")
//    UserProfile findByUserId(@Param("id") Long id);


}
