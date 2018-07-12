package com.kovacic.entity;

import com.kovacic.entity.base.AuditModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by ikovacic.
 */
@Entity(name = "users")
@Table(name = "users")
@DynamicInsert()
@DynamicUpdate()
@Getter
@Setter
public class User extends AuditModel {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "*Please provide your name")
    @Column(nullable = false, length = 50, unique = true)
    private String userName;

    @Column(name = "password")
    @NotEmpty(message = "*Please provide your password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
//    @Transient
    private String password;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = true, length = 500)
    private String note;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private SystemLogin systemLogin;

    @OneToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @OneToOne(fetch = FetchType.LAZY)
    private Priviledges priviledges;

    @Column(nullable = false)
    private boolean active;


    public User() {
    }




}
