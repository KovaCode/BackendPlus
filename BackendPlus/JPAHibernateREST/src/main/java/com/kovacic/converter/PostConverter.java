package com.kovacic.converter;

import com.kovacic.entity.Posts;
import com.kovacic.entity.dto.PostDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

/**
 * Created by ikovacic.
 */
public class PostConverter {

	public static Posts dtoToEntity(PostDto postDto) {
		ModelMapper mapper = new ModelMapper();
		Posts post = mapper.map(postDto, Posts.class);
		return post;
	}


	public static PostDto entityToDto(Posts post) {
		ModelMapper mapper = new ModelMapper();
		PostDto postDto = mapper.map(post, PostDto.class);
		return postDto;

	}


	public static List<PostDto> entityToDtoList(List<Posts> posts) {
		ModelMapper mapper = new ModelMapper();
		java.lang.reflect.Type targetListType = new TypeToken<List<PostDto>>() {}.getType();
		List<PostDto> postDtos = mapper.map(posts, targetListType);
		return postDtos;
	}

}
