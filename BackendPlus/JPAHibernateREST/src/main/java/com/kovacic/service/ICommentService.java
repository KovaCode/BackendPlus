package com.kovacic.service;

import com.kovacic.entity.dto.CommentDto;
import org.springframework.http.ResponseEntity;

/**
 * Created by ikovacic
 */
public interface ICommentService {

    ResponseEntity<CommentDto> getComment(Long id);

    ResponseEntity saveComment(CommentDto commentDto);

    ResponseEntity<CommentDto> updateComment(CommentDto commentDto);

    ResponseEntity deleteComment(CommentDto commentDto);

}
