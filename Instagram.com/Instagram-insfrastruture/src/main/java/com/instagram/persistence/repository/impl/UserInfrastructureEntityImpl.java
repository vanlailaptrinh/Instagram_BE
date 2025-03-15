package com.instagram.persistence.repository.impl;

import com.instagram.model.entity.UserDomainEntity;
import com.instagram.persistence.mapper.UserMapper;
import com.instagram.persistence.repository.JpaUserRepository;
import com.instagram.repository.user.UserDomainRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfrastructureEntityImpl implements UserDomainRepository {

    @Resource
    private JpaUserRepository jpaUserRepository;
    @Override
    public UserDomainEntity createUser(UserDomainEntity user) {
        return UserMapper.toDomain(jpaUserRepository.save(UserMapper.toEntity(user)));
    }
}
