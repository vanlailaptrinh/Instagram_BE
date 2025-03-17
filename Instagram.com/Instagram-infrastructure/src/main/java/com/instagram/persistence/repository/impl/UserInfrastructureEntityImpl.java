package com.instagram.persistence.repository.impl;

import com.instagram.model.entity.UserDomainEntity;
import com.instagram.persistence.mapper.UserMapper;
import com.instagram.persistence.repository.JpaUserRepository;
import com.instagram.repository.user.UserDomainRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// impl interface cua DomainRepository
public class UserInfrastructureEntityImpl implements UserDomainRepository {

    //rcm dùng Constructor Injection (giống C#)
    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public UserDomainEntity createUser(UserDomainEntity user) {
        return UserMapper.toDomain(jpaUserRepository.save(UserMapper.toEntity(user)));
    }

    @Override
    public List<UserDomainEntity> findUsersByUsername(String username){
        return jpaUserRepository.findByUsernameContaining(username)
                .stream()
                .map(UserMapper::toDomain)
                .toList();
    }

    @Override
    public List<UserDomainEntity> getAllUsers() {
        return jpaUserRepository.findAll()
                .stream()
                .map(UserMapper::toDomain)
                .toList();
    }
}
