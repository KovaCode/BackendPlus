package com.kovacic.service.impl;

import com.kovacic.converter.SystemLoginConverter;
import com.kovacic.entity.dto.SystemLoginDto;
import com.kovacic.repository.SystemLoginRepository;
import com.kovacic.service.ISystemLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemLoginServiceImpl implements ISystemLoginService {

    @Autowired
    SystemLoginRepository systemLoginRepository;

    @Override
    public ResponseEntity setLogged(boolean logged, Long userId) {
        systemLoginRepository.setLogged(logged, userId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<SystemLoginDto>> getAllSystemLogins() {
        List<SystemLoginDto> systemLoginDtoList = systemLoginRepository.findAll().stream().map(SystemLoginConverter::entityToDto).collect(Collectors.toList());
        return new ResponseEntity<>(systemLoginDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SystemLoginDto> getSystemLoginById(Long loginId) {
        return new ResponseEntity<>(SystemLoginConverter.entityToDto(systemLoginRepository.getOne(loginId)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveSystemLogin(SystemLoginDto systemLoginDto) {
        return new ResponseEntity<>(systemLoginRepository.save(SystemLoginConverter.dtoToEntity(systemLoginDto)), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<SystemLoginDto> updateSystemLogin(SystemLoginDto systemLoginDto) {
        return new ResponseEntity<>(SystemLoginConverter.entityToDto(systemLoginRepository.save(SystemLoginConverter.dtoToEntity(systemLoginDto))), HttpStatus.ACCEPTED);
    }
}
