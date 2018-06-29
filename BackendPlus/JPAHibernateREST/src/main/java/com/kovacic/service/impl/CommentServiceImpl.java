package com.kovacic.service.impl;

import com.kovacic.converter.CommentConverter;
import com.kovacic.entity.dto.CommentDto;
import com.kovacic.repository.CommentRepository;
import com.kovacic.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by ikovacic
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public ResponseEntity<CommentDto> getComment(Long id) {
        return new ResponseEntity<>(CommentConverter.entityToDto(commentRepository.getOne(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveComment(CommentDto commentDto) {
        commentRepository.save(CommentConverter.dtoToEntity(commentDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<CommentDto> updateComment(CommentDto commentDto) {
        return new ResponseEntity<>(CommentConverter.entityToDto(commentRepository.save(CommentConverter.dtoToEntity(commentDto))), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteComment(CommentDto commentDto) {
        commentRepository.delete(CommentConverter.dtoToEntity(commentDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
