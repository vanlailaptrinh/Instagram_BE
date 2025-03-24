package com.instagram.persistence.mapper;

import com.instagram.model.entity.CommentDomainEntity;
import com.instagram.persistence.model.entity.CommentInfrastructureEntity;

public class CommentMapper {
    public static CommentDomainEntity toDomain(CommentInfrastructureEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CommentDomainEntity(entity.getCommentId(), entity.getPostId(),
                entity.getUserId(), entity.getContent(), entity.getParentCommentId(), entity.getCreateAt());
    }

    public static CommentInfrastructureEntity toEntity(CommentDomainEntity domain) {
        if (domain == null) {
            return null;
        }
        return new CommentInfrastructureEntity(domain.getCommentId(), domain.getPostId(),
                domain.getUserId(), domain.getContent(), domain.getParentCommentId(), domain.getCreateAt(),domain.getDeleteAt());
    }
}
