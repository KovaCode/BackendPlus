package com.kovacic.converter;

import com.kovacic.entity.Category;
import com.kovacic.entity.dto.CategoryDto;
import org.modelmapper.ModelMapper;

/**
 * Created by ikovacic.
 */
public class CategoryConverter {

	public static Category dtoToEntity(CategoryDto categoryDto) {
		ModelMapper modelMapper = new ModelMapper();
		Category category = modelMapper.map(categoryDto, Category.class);
		return category;
	}

	public static CategoryDto entityToDto(Category category) {
		ModelMapper modelMapper = new ModelMapper();
		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}



}
