package com.instagram.services.user;

import com.instagram.model.entity.UserDomainEntity;

import java.util.List;

// interface này giúp Module Controller có thể giao tiếp với Module Application
public interface UserServices {
    UserDomainEntity createUser(UserDomainEntity user);
    List<UserDomainEntity> findUsersByUsername(String username);
    List<UserDomainEntity> getAllUsers();
}
