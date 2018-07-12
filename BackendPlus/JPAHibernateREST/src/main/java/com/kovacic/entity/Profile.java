package com.kovacic.entity;

import com.kovacic.entity.base.AuditModel;
import com.kovacic.enumerator.Country;
import com.kovacic.enumerator.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ikovacic.
 */
@Entity(name = "profiles")
@Table(name = "profiles")
@Setter
@Getter
public class Profile extends AuditModel {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 250)
    private String address1;

    @Column(length = 250)
    private String address2;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(length = 10)
    private String postalCode;

    @Column(length = 10)
    private String phoneNumber;

    @Column(length = 10)
    private String mobileNumber;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 100)
    private String email2;

    @Column()
    private LocalDate birthday;

    @Column(length = 100)
    private String note;

    @OneToOne(
            fetch = FetchType.EAGER)
    private File image;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "profile")
    private User user;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private List<Skill> skill;


    public Profile() {
    }


}
