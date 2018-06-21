package com.kovacic.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ikovacic.
 */
@Getter
@Setter
public class CountryDto {

    private String id;
    private String name;

    public CountryDto() {
    }

    public CountryDto(String name) {
        this.name = name;
    }

    public CountryDto(String id, String name) {
        this.id = id;
        this.name = name;
    }
}