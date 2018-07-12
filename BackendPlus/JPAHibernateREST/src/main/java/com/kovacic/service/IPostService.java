package com.kovacic.service;

import com.kovacic.entity.dto.PostDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ikovacic
 */
public interface IPostService {

    ResponseEntity<PostDto> getPost(Long id);

    ResponseEntity<List<PostDto>> getAllPostsPageable(Pageable pageable);

    ResponseEntity<List<PostDto>> getAllPosts();

    ResponseEntity savePost(PostDto postDto);

    ResponseEntity<PostDto> updatePost(PostDto postDto);

    ResponseEntity deletePost(PostDto postDto);

}
