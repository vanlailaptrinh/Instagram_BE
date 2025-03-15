package com.instagram.persistence.mapper;

import com.instagram.model.entity.UserDomainEntity;
import com.instagram.model.valueObject.Email;
import com.instagram.persistence.model.entity.UserInfrastructureEntity;

public class UserMapper {

    public static UserDomainEntity toDomain(UserInfrastructureEntity entity) {
        if (entity == null) {
            return null;
        }
        return new UserDomainEntity(
                entity.getUsername(),
                new Email(entity.getEmail()),
                entity.getPassword(),
                entity.isActive()
        );
    }

    public static UserInfrastructureEntity toEntity(UserDomainEntity domain) {
        if (domain == null) {
            return null;
        }
        UserInfrastructureEntity entity = new UserInfrastructureEntity();
        entity.setUsername(domain.getUsername());
        entity.setEmail(domain.getEmail().getValue());
        entity.setPassword(domain.getPassword());
        return entity;
    }
}
