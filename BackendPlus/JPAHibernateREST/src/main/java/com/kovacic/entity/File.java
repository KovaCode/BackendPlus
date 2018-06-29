package com.kovacic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ikovacic.
 */
@Entity
@Table(name = "file")
@Getter
@Setter
public class File {
    @Column
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(name = "type")
    private String type;
    @Column
    private String description;
    @Column(nullable = false)
    private byte[] file;


}