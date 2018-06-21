package com.kovacic.entity.dto;

import java.util.Date;


/**
 * Created by ikovacic.
 */

public class SystemLoginDto {

    private final Long ID;
    private final int wrongLoginCount;
    private Date lastLogin;
    private boolean logged;
    private final Long userId;

    public SystemLoginDto(Long id, int wrongLoginCount, Date lastLogin, boolean logged, Long userId) {
        this.ID = id;
        this.wrongLoginCount = wrongLoginCount;
        this.lastLogin = lastLogin;
        this.logged  = logged;
        this.userId = userId;
    }


    public Long getID() {
        return ID;
    }

    public int getWrongLoginCount() {
        return wrongLoginCount;
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

    public Long getUserId() {
        return userId;
    }
}
