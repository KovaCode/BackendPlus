package com.kovacic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ikovacic.
 */
@Entity
@Table(name = "skills")
@Getter
@Setter
public class Skill {
    @Column
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

//    @ManyToOne
////    @JoinColumn(name="profile")
//    private Profile profile;



    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Skill(Long ID, String name) {
        this.id = ID;
        this.name = name;
    }

}