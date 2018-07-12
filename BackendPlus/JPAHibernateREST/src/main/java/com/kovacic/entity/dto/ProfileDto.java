package com.kovacic.entity.dto;

import com.kovacic.enumerator.Country;
import com.kovacic.enumerator.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


/**
 * Created by ikovacic.
 */
@Setter
@Getter
public class ProfileDto{
    private String firstName;

    private String lastName;

    private String address1;

    private String address2;

    private String postalCode;

    private Gender gender;

    Country country;

    private String phoneNumber;

    private String mobileNumber;

    private String email;

    private String email2;

    private LocalDate birthday;

    private PriviledgesDto priviledges;

    private String note;

    private FileDto image;

    private UserDto user;

    private List<SkillDto> skill;

    public ProfileDto() {
    }

}
