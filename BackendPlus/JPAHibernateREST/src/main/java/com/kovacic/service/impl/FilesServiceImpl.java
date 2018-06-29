package com.kovacic.service.impl;

import com.kovacic.converter.FileConverter;
import com.kovacic.entity.File;
import com.kovacic.entity.dto.FileDto;
import com.kovacic.repository.FileRepository;
import com.kovacic.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class FilesServiceImpl implements IFileService {

    @Autowired
    FileRepository fileRepository;

    @Override
    public ResponseEntity<FileDto> getFile(Long id) {
        return new ResponseEntity<>(FileConverter.entityToDto(fileRepository.getOne(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveFile(FileDto fileDto) {
        return new ResponseEntity<>(FileConverter.entityToDto(fileRepository.save(FileConverter.dtoToEntity(fileDto))), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<FileDto> updateFile(FileDto fileDto) {
        File file = FileConverter.dtoToEntity(fileDto);
        file = fileRepository.save(file);
        return new ResponseEntity<>(FileConverter.entityToDto(file), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteFile(FileDto fileDto) {
        this.fileRepository.delete(FileConverter.dtoToEntity(fileDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
