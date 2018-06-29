package com.kovacic.service.impl;

import com.kovacic.converter.BlogConverter;
import com.kovacic.entity.dto.BlogDto;
import com.kovacic.repository.BlogRepository;
import com.kovacic.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by ikovacic
 */
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public ResponseEntity<BlogDto> getBlog(Long id) {
        return new ResponseEntity<>(BlogConverter.entityToDto(blogRepository.getOne(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveBlog(BlogDto blogDto) {
        blogRepository.save(BlogConverter.dtoToEntity(blogDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<BlogDto> updateBlog(BlogDto blogDto) {
        return new ResponseEntity<>(BlogConverter.entityToDto(blogRepository.save(BlogConverter.dtoToEntity(blogDto))), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteBlog(BlogDto blogDto) {
        blogRepository.delete(BlogConverter.dtoToEntity(blogDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
