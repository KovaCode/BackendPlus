package com.kovacic.converter;

import com.kovacic.entity.Profile;
import com.kovacic.entity.dto.ProfileDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

/**
 * Created by ikovacic
 */
public class UserProfileConverter {
    public static Profile dtoToEntity(ProfileDto userProfileDto) {
        ModelMapper modelMapper = new ModelMapper();
        Profile userProfile = modelMapper.map(userProfileDto, Profile.class);
        return userProfile;
    }

    public static ProfileDto entityToDto(Profile userProfile) {
        ModelMapper modelMapper = new ModelMapper();
        ProfileDto userProfileDto = modelMapper.map(userProfile, ProfileDto.class);
        return userProfileDto;
    }


    public static List<ProfileDto> entityToDtoList(List<Profile> profile) {
        ModelMapper mapper = new ModelMapper();
        java.lang.reflect.Type targetListType = new TypeToken<List<ProfileDto>>() {}.getType();
        List<ProfileDto> profileDtos = mapper.map(profile, targetListType);
        return profileDtos;
    }


}
