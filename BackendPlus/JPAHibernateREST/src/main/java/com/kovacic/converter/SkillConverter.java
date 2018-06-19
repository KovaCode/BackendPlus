package com.kovacic.converter;

import com.kovacic.entity.Skill;
import com.kovacic.entity.dto.SkillDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ikovacic.
 */
public class SkillConverter {

	public static Skill dtoToEntity(SkillDto SkillDto) {
		Skill Skill = new Skill(SkillDto.getName());
		Skill.setSkillId(SkillDto.getID());
		return Skill;
	}

	public static List<Skill> dtoToEntityList(List<SkillDto> listSkillDTO) {
		List<Skill> listSkill = new ArrayList<>();

		for (SkillDto skilldto : listSkillDTO) {
			listSkill.add(new Skill(skilldto.getID(), skilldto.getName()));
		}

		return listSkill;
	}


	public static SkillDto entityToDto(Skill skill) {
		return new SkillDto(skill.getID(), skill.getSkillName());
	}

	public static List<SkillDto> entityToDtoList(List<Skill> listSkill) {
		List<SkillDto> listSkillDTO = new ArrayList<>();

		for (Skill skill : listSkill) {
			listSkillDTO.add(new SkillDto(skill.getID(), skill.getSkillName()));
		}

		return listSkillDTO;
	}


}
