package com.instagram.services.user.impl;

import com.instagram.model.entity.UserDomainEntity;
import com.instagram.repository.user.UserDomainRepository;
import com.instagram.services.user.UserDomainServices;
import com.instagram.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices {
    //rcm dùng Constructor Injection (giống C#)
    @Autowired
    private UserDomainServices userDomainServices;
    @Override
    public UserDomainEntity createUser(UserDomainEntity user) {
        return userDomainServices.createUser(user);
    }
}
