package com.instagram.services.user;

import com.instagram.model.entity.UserDomainEntity;

import java.util.List;


// interface này giúp Module Application có thể giao tiếp với Module Domain
public interface UserDomainServices {
    UserDomainEntity createUser(UserDomainEntity user);
    List<UserDomainEntity> findUsersByUsername(String username);
    List<UserDomainEntity> getAllUsers();
}
