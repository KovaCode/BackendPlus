package com.kovacic.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ikovacic.
 */

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;

    public CategoryDto() {
    }

}
