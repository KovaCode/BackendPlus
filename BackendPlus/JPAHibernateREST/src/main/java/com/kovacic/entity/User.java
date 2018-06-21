package com.kovacic.entity;

import com.kovacic.entity.base.AuditModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;
/**
        * Created by ikovacic.
        */
@Entity
@Table(name = "user")
@DynamicInsert()
@DynamicUpdate()
public class User extends AuditModel {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, length = 50, unique = true)
    private String userName;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = true, length = 500)
    private String note;

    @JoinColumn(name = "user_id")
    @ManyToMany(
            fetch = FetchType.EAGER)
    private List<Skill> skill;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private SystemLogin systemLogin;

    public User() {
    }


    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, String userName, String password, String email, List<Skill> skills, String note) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.skill = skills;
        this.note = note;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long id) {
        this.ID = id;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Skill> getSkills() {
        return skill;
    }

    public void setSkills(List<Skill> skills) {
        this.skill = skills;
    }


    public SystemLogin getSystemLogin() {
        return systemLogin;
    }

    public void setSystemLogin(SystemLogin systemLogin) {
        this.systemLogin = systemLogin;
    }
}
