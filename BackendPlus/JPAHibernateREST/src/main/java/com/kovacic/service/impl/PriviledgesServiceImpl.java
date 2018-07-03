package com.kovacic.service.impl;

import com.kovacic.converter.PriviledgesConverter;
import com.kovacic.entity.dto.PriviledgesDto;
import com.kovacic.repository.PriviledgesRepository;
import com.kovacic.service.IPriviledgesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PriviledgesServiceImpl implements IPriviledgesService {

    @Autowired
    PriviledgesRepository priviledgesRepository;

//    IGenericDao<Priviledges> dao;
//
//    @Autowired
//    public void setDao(IGenericDao<Priviledges> daoToSet ){
//        dao = daoToSet;
//        dao.setClazz(Priviledges.class );
//    }

    @Override
    public ResponseEntity<PriviledgesDto> getOne(Long id) {
        return new ResponseEntity<>(PriviledgesConverter.entityToDto(priviledgesRepository.getOne(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PriviledgesDto> save(PriviledgesDto priviledgesDto) {
        return new ResponseEntity(PriviledgesConverter.entityToDto(priviledgesRepository.save(PriviledgesConverter.dtoToEntity(priviledgesDto))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PriviledgesDto> update(PriviledgesDto priviledgesDto) {
        return new ResponseEntity<>(PriviledgesConverter.entityToDto(priviledgesRepository.save(PriviledgesConverter.dtoToEntity(priviledgesDto))), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity delete(PriviledgesDto priviledgesDto) {
        priviledgesRepository.delete(PriviledgesConverter.dtoToEntity(priviledgesDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
