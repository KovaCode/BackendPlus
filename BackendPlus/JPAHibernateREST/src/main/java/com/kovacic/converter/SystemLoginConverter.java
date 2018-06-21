package com.kovacic.converter;

import com.kovacic.entity.SystemLogin;
import com.kovacic.entity.dto.SystemLoginDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ikovaci.
 */
public class SystemLoginConverter {

    public static SystemLogin dtoToEntity(SystemLoginDto systemLoginDto) {
        SystemLogin systemLogin = new SystemLogin(systemLoginDto.getID(), systemLoginDto.getWrongLoginCount(), systemLoginDto.getLastLogin(), systemLoginDto.isLogged());
        return systemLogin;
    }

    public static SystemLoginDto entityToDto(SystemLogin systemLogin) {
        SystemLoginDto systemLoginDto = new SystemLoginDto(systemLogin.getID(), systemLogin.getWrongLoginCount(), systemLogin.getLastLogin(), systemLogin.isLogged(), systemLogin.getUser().getID());
        return systemLoginDto;
    }

    public static List<SystemLoginDto> entityToDtList(List<SystemLogin> listSystemLogin) {
        List<SystemLoginDto> systemLoginDtoList = new ArrayList<>();

        for (SystemLogin systemLogin : listSystemLogin) {
            SystemLoginDto systemLoginDto = new SystemLoginDto(systemLogin.getID(), systemLogin.getWrongLoginCount(), systemLogin.getLastLogin(), systemLogin.isLogged(), systemLogin.getUser().getID());
            systemLoginDtoList.add(systemLoginDto);
        }

        return systemLoginDtoList;
    }
}
