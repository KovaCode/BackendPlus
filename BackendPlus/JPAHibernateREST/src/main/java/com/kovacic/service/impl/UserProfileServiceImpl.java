package com.kovacic.service.impl;

import com.kovacic.converter.UserProfileConverter;
import com.kovacic.entity.dto.UserProfileDto;
import com.kovacic.repository.UserProfileRepository;
import com.kovacic.service.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements IUserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public ResponseEntity<UserProfileDto> getUserProfileById(Long profileId) {
        return new ResponseEntity<>(UserProfileConverter.entityToDto(userProfileRepository.getOne(profileId)), HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<UserProfileDto> getUserProfileByUserId(Long userId) {
//        return new ResponseEntity<>(UserProfileConverter.entityToDto(userProfileRepository.findByUserId(userId)), HttpStatus.OK);
//    }

    @Override
    public ResponseEntity saveUserProfile(UserProfileDto userProfileDto) {
        userProfileRepository.save(UserProfileConverter.dtoToEntity(userProfileDto));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<UserProfileDto> updateUserProfile(UserProfileDto userProfileDto) {
        userProfileRepository.save(UserProfileConverter.dtoToEntity(userProfileDto));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteUserProfile(Long profileId) {
        userProfileRepository.deleteById(profileId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteUserProfile(UserProfileDto userProfileDto) {
        userProfileRepository.delete(UserProfileConverter.dtoToEntity(userProfileDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
