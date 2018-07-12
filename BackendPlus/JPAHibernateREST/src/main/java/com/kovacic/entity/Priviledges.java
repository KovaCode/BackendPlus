package com.kovacic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
        * Created by ikovacic.
        */
@Entity
@Table(name = "priviledges")
@Getter
@Setter
public class Priviledges implements Serializable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private int level;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "priviledges")
    private User user;


    public Priviledges() {
    }


    public Priviledges(String name, int level) {
        this.name = name;
        this.level = level;
    }

}
