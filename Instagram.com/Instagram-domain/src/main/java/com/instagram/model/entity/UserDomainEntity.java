package com.instagram.model.entity;

import com.instagram.model.valueObject.Email;

import java.util.UUID;

public class UserDomainEntity {
    private UUID id;
    private String username;
    private Email email;
    private String password;
    private boolean isActive;

    public UserDomainEntity() {
    }

    public UserDomainEntity(String username, Email email, String password, boolean isActive) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public UserDomainEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }
    public String getPassword() {
        return password;
    }
}
