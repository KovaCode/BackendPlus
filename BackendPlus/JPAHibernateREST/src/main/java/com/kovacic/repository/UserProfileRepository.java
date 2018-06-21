package com.kovacic.repository;

import com.kovacic.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ikovacic.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

//    @Query("SELECT p FROM profile p WHERE p.id = (select up.id_profile from user_profile up where up.id_user=:id)")
//    UserProfile findByUserId(@Param("id") Long id);


}
