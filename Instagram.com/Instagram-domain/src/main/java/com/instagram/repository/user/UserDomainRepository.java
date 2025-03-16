package com.instagram.repository.user;

import com.instagram.model.entity.UserDomainEntity;

import java.util.List;

// interface giúp Module Infrastructure có thể biết được nghiệp vụ của hệ thống (vd: createUser())
public interface UserDomainRepository {
    UserDomainEntity createUser(UserDomainEntity user);
    List<UserDomainEntity> findUsersByUsername(String username);
    List<UserDomainEntity> getAllUsers();
}
