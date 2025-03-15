package com.instagram.services.user.impl;

import com.instagram.model.entity.UserDomainEntity;
import com.instagram.repository.user.UserDomainRepository;
import com.instagram.services.user.UserDomainServices;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserDomainServicesImpl implements UserDomainServices {

    @Resource
    private UserDomainRepository userDomainRepository;
    @Override
    public UserDomainEntity createUser(UserDomainEntity user) {
        return userDomainRepository.createUser(user);
    }
}
