package com.kovacic.converter;

import com.kovacic.entity.Blog;
import com.kovacic.entity.dto.BlogDto;
import org.modelmapper.ModelMapper;

/**
 * Created by ikovacic.
 */
public class BlogConverter {

	public static Blog dtoToEntity(BlogDto blogDto) {
		ModelMapper modelMapper = new ModelMapper();
		Blog blog = modelMapper.map(blogDto, Blog.class);
		return blog;
	}

	public static BlogDto entityToDto(Blog blog) {
		ModelMapper modelMapper = new ModelMapper();
		BlogDto blogDto = modelMapper.map(blog, BlogDto.class);
		return blogDto;
	}



}
