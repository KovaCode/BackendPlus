package com.kovacic.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ikovacic.
 */

@Getter
@Setter
public class UserDto {
    private Long ID;
    private String userName;
    private String password;
    private String email;
    private String note;
    private boolean active;
//    private PriviledgesDto priviledgesDto;

    public UserDto() {
    }



}
