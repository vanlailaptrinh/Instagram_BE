package com.instagram.services.user.impl;

import com.instagram.model.entity.UserDomainEntity;
import com.instagram.repository.user.UserDomainRepository;
import com.instagram.services.user.UserDomainServices;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//impl interface của DomainServices
public class UserDomainServicesImpl implements UserDomainServices {

    //rcm dùng Constructor Injection (giống C#)
    @Autowired
    private UserDomainRepository userDomainRepository;
    // tìm 1 Bean tương ứng trong Spring Context để tiêm vào, cụ thể là lớp UserInfrastructureEntityImpl

    @Override
    public UserDomainEntity createUser(UserDomainEntity user) {
        return userDomainRepository.createUser(user);
    }

    @Override
    public List<UserDomainEntity> findUsersByUsername(String username){
        return userDomainRepository.findUsersByUsername(username);
    }

    @Override
    public List<UserDomainEntity> getAllUsers() {
        return userDomainRepository.getAllUsers();
    }
}
