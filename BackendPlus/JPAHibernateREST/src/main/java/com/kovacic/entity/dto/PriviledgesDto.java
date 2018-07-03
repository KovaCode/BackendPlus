package com.kovacic.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ikovacic.
 */
@Getter
@Setter
public class PriviledgesDto {
    private Long id;
    private String name;
    private int level;

    public PriviledgesDto() {
    }

}
