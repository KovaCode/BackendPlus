package com.kovacic.service;

import com.kovacic.entity.dto.UserProfileDto;
import org.springframework.http.ResponseEntity;

/**
 * Created by ikovacic
 */
public interface IUserProfileService {


    ResponseEntity<UserProfileDto> getUserProfileById(Long loginId);

//    ResponseEntity<UserProfileDto> getUserProfileByUserId(Long loginId);

    ResponseEntity saveUserProfile(UserProfileDto userProfileDto);

    ResponseEntity<UserProfileDto> updateUserProfile(UserProfileDto userProfileDto);

    ResponseEntity deleteUserProfile(Long profileId);

    ResponseEntity deleteUserProfile(UserProfileDto userProfileDto);

}
