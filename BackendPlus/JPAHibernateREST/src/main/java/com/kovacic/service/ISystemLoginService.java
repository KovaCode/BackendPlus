package com.kovacic.service;

import com.kovacic.entity.dto.SystemLoginDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ikovacic
 */
public interface ISystemLoginService {

    ResponseEntity setLogged(boolean logged, Long userId);

    ResponseEntity<List<SystemLoginDto>> getAllSystemLogins();

    ResponseEntity<SystemLoginDto> getSystemLoginById(Long loginId);

    ResponseEntity saveSystemLogin(SystemLoginDto systemLoginDto);

    ResponseEntity<SystemLoginDto> updateSystemLogin(SystemLoginDto systemLoginDto);


}
