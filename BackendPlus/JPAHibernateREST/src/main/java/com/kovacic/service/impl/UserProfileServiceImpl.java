package com.kovacic.service.impl;

import com.kovacic.converter.UserProfileConverter;
import com.kovacic.entity.dto.ProfileDto;
import com.kovacic.repository.ProfileRepository;
import com.kovacic.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements IProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public List<ProfileDto> getAll() {
        return UserProfileConverter.entityToDtoList(profileRepository.findAll());
    }

    @Override
    public ResponseEntity<ProfileDto> getProfileById(Long profileId) {
        return new ResponseEntity<>(UserProfileConverter.entityToDto(profileRepository.getOne(profileId)), HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<UserProfileDto> getUserProfileByUserId(Long userId) {
//        return new ResponseEntity<>(UserProfileConverter.entityToDto(profileRepository.findByUserId(userId)), HttpStatus.OK);
//    }

    @Override
    public ResponseEntity saveProfile(ProfileDto userProfileDto) {
        profileRepository.save(UserProfileConverter.dtoToEntity(userProfileDto));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<ProfileDto> updateProfile(ProfileDto userProfileDto) {
        profileRepository.save(UserProfileConverter.dtoToEntity(userProfileDto));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteProfile(Long profileId) {
        profileRepository.deleteById(profileId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteProfile(ProfileDto userProfileDto) {
        profileRepository.delete(UserProfileConverter.dtoToEntity(userProfileDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
