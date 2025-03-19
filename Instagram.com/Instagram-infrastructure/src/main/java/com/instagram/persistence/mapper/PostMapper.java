package com.instagram.persistence.mapper;

import com.instagram.model.entity.PostDomainEntity;
import com.instagram.persistence.model.entity.PostInfrastructureEntity;


public class PostMapper {


    public static PostInfrastructureEntity toEntity(PostDomainEntity domain) {
        if (domain == null) {
            return null;
        }
        PostInfrastructureEntity entity = new PostInfrastructureEntity();
        entity.setUserId(domain.getUserId());
        entity.setCaption(domain.getCaption());
        entity.setCreatedAt(domain.getCreatedAt());
        return entity;

    }

}
