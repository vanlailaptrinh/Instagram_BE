package com.instagram.services.user;

import com.instagram.model.entity.UserDomainEntity;


// interface này giúp Module Application có thể giao tiếp với Module Domain
public interface UserDomainServices {
    UserDomainEntity createUser(UserDomainEntity user);
}
