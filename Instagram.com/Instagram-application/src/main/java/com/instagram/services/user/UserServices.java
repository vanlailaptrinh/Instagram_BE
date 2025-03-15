package com.instagram.services.user;

import com.instagram.model.entity.UserDomainEntity;

public interface UserServices {
    UserDomainEntity createUser(UserDomainEntity user);
}
