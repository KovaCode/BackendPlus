package com.kovacic.converter;

import com.kovacic.entity.Skill;
import com.kovacic.entity.dto.SkillDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

/**
 * Created by ikovacic.
 */
public class SkillConverter {

    public static Skill dtoToEntity(SkillDto skillDto) {
        ModelMapper modelMapper = new ModelMapper();
        Skill skill = modelMapper.map(skillDto, Skill.class);
        return skill;
    }

    public static SkillDto entityToDto(Skill skill) {
        ModelMapper modelMapper = new ModelMapper();
        SkillDto skillDto = modelMapper.map(skill, SkillDto.class);
        return skillDto;
    }

    public static List<SkillDto> entityToDtoList(List<Skill> skills) {
        ModelMapper mapper = new ModelMapper();
        java.lang.reflect.Type targetListType = new TypeToken<List<SkillDto>>() {
        }.getType();
        List<SkillDto> skillDtos = mapper.map(skills, targetListType);
        return skillDtos;
    }

}