package com.instagram.services.user.impl;

import com.instagram.model.entity.UserDomainEntity;
import com.instagram.repository.user.UserDomainRepository;
import com.instagram.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices {

    @Autowired
    private UserDomainRepository userDomainRepository;
    @Override
    public UserDomainEntity createUser(UserDomainEntity user) {
        return userDomainRepository.createUser(user);
    }
}
