package com.kovacic.converter;

import com.kovacic.entity.SystemLogin;
import com.kovacic.entity.dto.SystemLoginDto;
import org.modelmapper.ModelMapper;

/**
 * Created by ikovaci.
 */
public class SystemLoginConverter {

    public static SystemLogin dtoToEntity(SystemLoginDto systemLoginDto) {
//        SystemLogin systemLogin = new SystemLogin(systemLoginDto.getID(), systemLoginDto.getWrongLoginCount(), systemLoginDto.getLastLogin(), systemLoginDto.isLogged());
//        return systemLogin;

        ModelMapper modelMapper = new ModelMapper();
        SystemLogin systemLogin = modelMapper.map(systemLoginDto, SystemLogin.class);
        return systemLogin;
    }

    public static SystemLoginDto entityToDto(SystemLogin systemLogin) {
//        SystemLoginDto systemLoginDto = new SystemLoginDto(systemLogin.getID(), systemLogin.getWrongLoginCount(), systemLogin.getLastLogin(), systemLogin.isLogged(), systemLogin.getUser().getID());
//        return systemLoginDto;

        ModelMapper modelMapper = new ModelMapper();
        SystemLoginDto systemLoginDto = modelMapper.map(systemLogin, SystemLoginDto.class);
        return systemLoginDto;

    }

//    public static List<SystemLoginDto> entityToDtList(List<SystemLogin> listSystemLogin) {
//        List<SystemLoginDto> systemLoginDtoList = new ArrayList<>();
//
//        for (SystemLogin systemLogin : listSystemLogin) {
//            SystemLoginDto systemLoginDto = new SystemLoginDto(systemLogin.getID(), systemLogin.getWrongLoginCount(), systemLogin.getLastLogin(), systemLogin.isLogged(), systemLogin.getUser().getID());
//            systemLoginDtoList.add(systemLoginDto);
//        }
//
//        return systemLoginDtoList;
//    }
}
