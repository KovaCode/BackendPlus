package com.kovacic.converter;

import com.kovacic.entity.File;
import com.kovacic.entity.dto.FileDto;
import org.modelmapper.ModelMapper;

/**
 * Created by ikovacic.
 */
public class FileConverter {

	public static File dtoToEntity(FileDto fileDto) {
		ModelMapper modelMapper = new ModelMapper();
		File file = modelMapper.map(fileDto, File.class);
		return file;
	}

	public static FileDto entityToDto(File file) {
		ModelMapper modelMapper = new ModelMapper();
		FileDto fileDto = modelMapper.map(file, FileDto.class);
		return fileDto;
	}



}
