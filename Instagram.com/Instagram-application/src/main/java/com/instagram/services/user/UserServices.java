package com.instagram.services.user;

import com.instagram.model.entity.UserDomainEntity;

// interface này giúp Module Controller có thể giao tiếp với Module Application
public interface UserServices {
    UserDomainEntity createUser(UserDomainEntity user);
}
