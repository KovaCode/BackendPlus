package com.kovacic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
        * Created by ikovacic.
        */
@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category implements Serializable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    public Category() {
    }

}
