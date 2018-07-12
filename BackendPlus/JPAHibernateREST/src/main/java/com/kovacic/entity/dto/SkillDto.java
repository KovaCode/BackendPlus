package com.kovacic.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ikovacic.
 */

@Getter
@Setter
public class SkillDto {
    Long id;
    String name;

    public SkillDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SkillDto(String name) {
        this.name = name;
    }

    public SkillDto() {
    }

}
