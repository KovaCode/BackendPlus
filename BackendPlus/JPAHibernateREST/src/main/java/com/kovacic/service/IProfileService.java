package com.kovacic.service;

import com.kovacic.entity.dto.ProfileDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ikovacic
 */
public interface IProfileService {

    List<ProfileDto> getAll();

    ResponseEntity<ProfileDto> getProfileById(Long loginId);

//    ResponseEntity<UserProfileDto> getProfileByUserId(Long loginId);

    ResponseEntity saveProfile(ProfileDto userProfileDto);

    ResponseEntity<ProfileDto> updateProfile(ProfileDto userProfileDto);

    ResponseEntity deleteProfile(Long profileId);

    ResponseEntity deleteProfile(ProfileDto userProfileDto);

}
