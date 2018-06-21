package com.kovacic.entity;

import javax.persistence.*;

/**
 * Created by ikovacic.
 */
@Entity
@Table(name = "skill")
public class Skill {
    @Column
    @Id
    @GeneratedValue
    private Long ID;
    @Column(unique = true)
    private String name;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Skill(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }


    public Long getID() {
        return ID;
    }

    public void setSkillId(Long ID) {
        this.ID = ID;
    }

    public String getSkillName() {
        return name;
    }

    public void setSkillName(String name) {
        this.name = name;
    }
}