package com.kovacic.entity;

import com.kovacic.entity.base.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
        * Created by ikovacic.
        */
@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment extends AuditModel {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comment;

    @JoinColumn(name = "user_id")
    @OneToOne(
            fetch = FetchType.EAGER)
    private User user;


    public Comment() {
    }

}
