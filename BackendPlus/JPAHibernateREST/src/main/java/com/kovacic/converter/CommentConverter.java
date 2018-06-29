package com.kovacic.converter;

import com.kovacic.entity.Comment;
import com.kovacic.entity.dto.CommentDto;
import org.modelmapper.ModelMapper;

/**
 * Created by ikovacic.
 */
public class CommentConverter {

	public static Comment dtoToEntity(CommentDto commentDto) {
		ModelMapper modelMapper = new ModelMapper();
		Comment comment = modelMapper.map(commentDto, Comment.class);
		return comment;
	}

	public static CommentDto entityToDto(Comment comment) {
		ModelMapper modelMapper = new ModelMapper();
		CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
		return commentDto;
	}



}
