package com.kovacic.controler.rest;

import com.kovacic.entity.dto.PostDto;
import com.kovacic.service.IPostService;
import com.kovacic.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ikovacic
 */
@RequestMapping("/posts")
@RestController
public class PostController {
    @Autowired
    private IPostService postService;

    @RequestMapping(Constants.GET_POST_BY_ID)
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @RequestMapping(Constants.GET_ALL_POSTS)
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return postService.getAllPosts();
    }


    @PutMapping(Constants.UPDATE_POST2)
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto) {
        return postService.updatePost(postDto);
    }

    @PostMapping(value = Constants.SAVE_POST)
    public ResponseEntity savePost(@RequestBody PostDto postDto) {
        return postService.savePost(postDto);
    }

    @DeleteMapping(value = Constants.DELETE_POST)
    public ResponseEntity deletePost(@RequestBody PostDto postDto) {
        return postService.deletePost(postDto);
    }


}
