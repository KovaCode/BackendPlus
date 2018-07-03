package com.kovacic.converter;

import com.kovacic.entity.Priviledges;
import com.kovacic.entity.dto.PriviledgesDto;
import org.modelmapper.ModelMapper;

/**
 * Created by ikovacic.
 */
public class PriviledgesConverter {

	public static Priviledges dtoToEntity(PriviledgesDto priviledgesDto) {
		ModelMapper modelMapper = new ModelMapper();
		Priviledges priviledges = modelMapper.map(priviledgesDto, Priviledges.class);
		return priviledges;
	}

	public static PriviledgesDto entityToDto(Priviledges priviledges) {
		ModelMapper modelMapper = new ModelMapper();
		PriviledgesDto priviledgesDto = modelMapper.map(priviledges, PriviledgesDto.class);
		return priviledgesDto;
	}



}
