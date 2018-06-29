package com.kovacic.service;

import com.kovacic.entity.dto.BlogDto;
import org.springframework.http.ResponseEntity;

/**
 * Created by ikovacic
 */
public interface IBlogService {

    ResponseEntity<BlogDto> getBlog(Long id);

    ResponseEntity saveBlog(BlogDto blogDto);

    ResponseEntity<BlogDto> updateBlog(BlogDto blogDto);

    ResponseEntity deleteBlog(BlogDto blogDto);

}
