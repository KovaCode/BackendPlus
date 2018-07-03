package com.kovacic.service;

import com.kovacic.entity.dto.PriviledgesDto;
import org.springframework.http.ResponseEntity;

/**
 * Created by ikovacic
 */
public interface IPriviledgesService {



    ResponseEntity<PriviledgesDto> getOne(Long id);

    ResponseEntity save(PriviledgesDto priviledgesDto);

    ResponseEntity<PriviledgesDto> update(PriviledgesDto priviledgesDto);

    ResponseEntity delete(PriviledgesDto priviledgesDto);

}
