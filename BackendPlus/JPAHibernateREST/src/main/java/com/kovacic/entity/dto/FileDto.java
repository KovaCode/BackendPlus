package com.kovacic.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ikovacic.
 */
@Getter
@Setter
public class FileDto {
    private Long id;
    private String name;
    private String type;
    private String description;
    private byte[] file;


}