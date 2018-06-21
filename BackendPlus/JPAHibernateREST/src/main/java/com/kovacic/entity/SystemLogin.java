package com.kovacic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ikovacic.
 */
@Entity
@Table(name = "systemLogin")
public class SystemLogin {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    int wrongLoginCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastLogin", nullable = false, updatable = false)
    @UpdateTimestamp
    private Date lastLogin;

    @Column(name = "logged", nullable = false, updatable = false)
    boolean logged;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
//
//    @Column
//    private Long userId;


    public SystemLogin() {
    }

    public SystemLogin(Long id,int wrongLoginCount, Date lastLogin, boolean logged) {
        this.id = id;
        this.wrongLoginCount = wrongLoginCount;
        this.lastLogin = lastLogin;
        this.logged = logged;
    }

    public SystemLogin(int wrongLoginCount, Date lastLogin, boolean logged) {
        this.wrongLoginCount = wrongLoginCount;
        this.lastLogin = lastLogin;
        this.logged = logged;
    }


    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
    }

    public int getWrongLoginCount() {
        return wrongLoginCount;
    }

    public void setWrongLoginCount(int wrongLoginCount) {
        this.wrongLoginCount = wrongLoginCount;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
