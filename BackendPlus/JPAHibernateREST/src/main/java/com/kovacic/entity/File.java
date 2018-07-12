package com.kovacic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ikovacic.
 */
@Entity
@Table(name = "files")
@Getter
@Setter
public class File implements Serializable {
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
    @Lob
    @Column(name="pic")
    private byte[] pic;

    public File() {
    }
}