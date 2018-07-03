package com.kovacic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
        * Created by ikovacic.
        */
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    public Category() {
    }

}
