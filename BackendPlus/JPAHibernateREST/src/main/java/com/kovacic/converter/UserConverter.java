package com.kovacic.converter;

import com.kovacic.entity.User;
import com.kovacic.entity.dto.UserDto;
import org.modelmapper.ModelMapper;

/**
 * Created by ikovacic
 */
public class UserConverter {

    public static User dtoToEntity(UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    public static UserDto entityToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto= modelMapper.map(user, UserDto.class);
        return userDto;
    }


//    public static User dtoToEntity(UserDto userDto) {
//        User user = new User(userDto.getUserName(), userDto.getPassword(), userDto.getEmail(), SkillConverter.dtoToEntityList(userDto.getSkillDtos()), userDto.getNote());
////        user.setID(userDto.getID());
//        return user;
//    }
//
//    public static UserDto entityToDto(User user) {
//        UserDto userDto = new UserDto(user.getID(), user.getUserName(), user.getPassword(), user.getEmail(), SkillConverter.entityToDtoList(user.getSkills()), user.getNote());
//        return userDto;
//    }
//
//    public static List<UserDto> listEntityToDto(List<User> users) {
//        List<UserDto> userDtoList = new ArrayList<>();
//
//        for (User user : users) {
//            UserDto userDto = new UserDto(user.getID(), user.getUserName(), user.getPassword(), user.getEmail());
//            userDtoList.add(userDto);
//        }
//        return userDtoList;
//    }

}
