package com.kovacic.service;

import com.kovacic.entity.dto.FileDto;
import org.springframework.http.ResponseEntity;

/**
 * Created by ikovacic
 */
public interface IFileService {

    ResponseEntity<FileDto> getFile(Long id);

    ResponseEntity saveFile(FileDto fileDto);

    ResponseEntity<FileDto> updateFile(FileDto fileDto);

    ResponseEntity deleteFile(FileDto fileDto);

}
