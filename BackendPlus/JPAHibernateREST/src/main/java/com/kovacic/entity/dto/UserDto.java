package com.kovacic.entity.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ikovacic.
 */
public class UserDto {
    private Long ID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private List<SkillDto> skillDtos = new ArrayList<>();
    private String note;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String userName, String password, String email, String note) {
        this.ID = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skillDtos = null;
        this.note = note;
    }

    public UserDto(Long id, String firstName, String lastName, String userName, String password, String email, List<SkillDto> skillDtos) {
        this.ID = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skillDtos = skillDtos;
//        this.note = null;
    }

    public UserDto(Long id, String firstName, String lastName, String userName, String password, String email, List<SkillDto> skillDtos, String note) {
        this.ID = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skillDtos = skillDtos;
        this.note = note;
    }

    public UserDto(String firstName, String lastName, String userName, String password, String email, List<SkillDto> skillDtos, String note) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skillDtos = skillDtos;
        this.note = note;
    }


    public UserDto(Long id, String firstName, String lastName, String userName, String password, String email) {
        this.ID = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skillDtos = null;
//        this.note = null;
    }



    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<SkillDto> getSkillDtos() {
        return skillDtos;
    }

    public void setSkillDtos(List<SkillDto> skillDtos) {
        this.skillDtos = skillDtos;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
