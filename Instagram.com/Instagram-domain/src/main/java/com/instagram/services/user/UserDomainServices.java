package com.instagram.services.user;

import com.instagram.model.entity.UserDomainEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// interface này giúp Module Application có thể giao tiếp với Module Domain
public interface UserDomainServices {
    UserDomainEntity createUser(UserDomainEntity user);
    UserDomainEntity updateUser(UserDomainEntity user, UUID userId);
    void deleteUser(UUID userId);
    List<UserDomainEntity> findUsersByUsername(String username);
    List<UserDomainEntity> getAllUsers();
}
