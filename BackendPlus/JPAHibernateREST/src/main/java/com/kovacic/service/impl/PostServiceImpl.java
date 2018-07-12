package com.kovacic.service.impl;

import com.kovacic.converter.PostConverter;
import com.kovacic.entity.Posts;
import com.kovacic.entity.dto.PostDto;
import com.kovacic.repository.PostRepository;
import com.kovacic.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public ResponseEntity<PostDto> getPost(Long id) {
        return new ResponseEntity<>(PostConverter.entityToDto(postRepository.getOne(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostDto>> getAllPostsPageable(Pageable pageable) {
        List<PostDto> postDtoList = PostConverter.entityToDtoList((List<Posts>)postRepository.findAll(pageable));
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> postDtoList = PostConverter.entityToDtoList(postRepository.findAll());
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity savePost(PostDto postDto) {
        postRepository.save(PostConverter.dtoToEntity(postDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<PostDto> updatePost(PostDto postDto) {
        return new ResponseEntity(postRepository.save(PostConverter.dtoToEntity(postDto)), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deletePost(PostDto postDto) {
        postRepository.delete(PostConverter.dtoToEntity(postDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }
}
