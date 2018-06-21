package com.kovacic.entity.dto;

import com.kovacic.entity.Country;
import com.kovacic.enumerator.Gender;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Created by ikovacic.
 */
@Setter
@Getter
public class UserProfileDto{
    private String firstName;

    private String lastName;

    private String address1;

    private String address2;

    private Gender gender;

    ArrayList<Country> country;

    private BigInteger phoneNumber;

    private BigInteger mobileNumber;

    private String email;

    private String email2;

    private LocalDate birthday;

    private String note;

    public UserProfileDto() {
    }

    public UserProfileDto(String firstName, String lastName, String address1, String address2, Gender gender, ArrayList<Country> country, BigInteger phoneNumber, BigInteger mobileNumber, String email, String email2, LocalDate birthday, String note) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.gender = gender;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.email2 = email2;
        this.birthday = birthday;
        this.note = note;
    }

}
