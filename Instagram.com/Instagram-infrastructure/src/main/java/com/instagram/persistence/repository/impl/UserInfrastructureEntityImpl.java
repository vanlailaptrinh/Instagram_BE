package com.instagram.persistence.repository.impl;

import com.instagram.model.entity.UserDomainEntity;
import com.instagram.persistence.mapper.UserMapper;
import com.instagram.persistence.model.entity.UserInfrastructureEntity;
import com.instagram.persistence.repository.JpaUserRepository;
import com.instagram.repository.user.UserDomainRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public UserDomainEntity updateUser(UserDomainEntity user, UUID userId){
        UserInfrastructureEntity existingUser = jpaUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(UserMapper.toEntity(user).getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setActive(user.isActive());

        UserInfrastructureEntity updateUser = jpaUserRepository.save(existingUser);
        return UserMapper.toDomain(updateUser);
    }

    @Override
    public void deleteUser(UUID userId) {
        jpaUserRepository.findById(userId).ifPresentOrElse(
                user -> jpaUserRepository.deleteById(userId),
                () -> {
                    throw new RuntimeException("User not found");
                }
        );
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

    @Override
    public UserDomainEntity findUsersById(UUID userId) {
        return jpaUserRepository.findById(userId)
                .map(UserMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("User không tồn tại với id: " + userId));
    }

}
