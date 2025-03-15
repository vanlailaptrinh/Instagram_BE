package com.instagram.repository.user;

import com.instagram.model.entity.UserDomainEntity;

public interface UserDomainRepository {
    UserDomainEntity createUser(UserDomainEntity user);
}
