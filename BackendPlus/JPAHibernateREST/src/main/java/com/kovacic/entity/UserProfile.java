package com.kovacic.entity;

import com.kovacic.entity.base.AuditModel;
import com.kovacic.enumerator.Country;
import com.kovacic.enumerator.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

/**
 * Created by ikovacic.
 */
@Entity(name = "profile")
@Table(name = "profile")
@Setter
@Getter
public class UserProfile extends AuditModel {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

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

//    @ElementCollection(targetClass = Country.class)
//    @CollectionTable(name = "country", joinColumns = @JoinColumn(name = "country_id"))
//    @Column(name = "country", nullable = false)
//    @Enumerated(EnumType.STRING)
//    ArrayList<Country> country;

    @Column(length = 10)
    private BigInteger phoneNumber;

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

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "image_id")
    @OneToOne(
            fetch = FetchType.EAGER)
    private File image;

    public UserProfile() {
    }


}
