package com.kovacic.converter;

import com.kovacic.entity.UserProfile;
import com.kovacic.entity.dto.UserProfileDto;
import org.modelmapper.ModelMapper;

/**
 * Created by ikovacic
 */
public class UserProfileConverter {
    public static UserProfile dtoToEntity(UserProfileDto userProfileDto) {
        ModelMapper modelMapper = new ModelMapper();
        UserProfile userProfile = modelMapper.map(userProfileDto, UserProfile.class);
        return userProfile;
    }

    public static UserProfileDto entityToDto(UserProfile userProfile) {
        ModelMapper modelMapper = new ModelMapper();
        UserProfileDto userProfileDto = modelMapper.map(userProfile, UserProfileDto.class);
        return userProfileDto;
    }


}
