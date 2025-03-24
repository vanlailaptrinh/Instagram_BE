package com.instagram.persistence.repository.impl;

import com.instagram.model.entity.CommentDomainEntity;
import com.instagram.persistence.mapper.CommentMapper;
import com.instagram.persistence.model.entity.CommentInfrastructureEntity;
import com.instagram.persistence.repository.JpaCommentRepository;
import com.instagram.persistence.repository.JpaPostRepository;
import com.instagram.repository.comment.CommentDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CommentInfrastructerEntityImpl implements CommentDomainRepository {
    private final JpaCommentRepository jpaCommentRepository;
    private final JpaPostRepository jpaPostRepository;

    @Override
    public CommentDomainEntity createComment(CommentDomainEntity comment) {
        return CommentMapper.toDomain(jpaCommentRepository.save(CommentMapper.toEntity(comment)));
    }

    @Override
    public CommentDomainEntity updateComment(CommentDomainEntity comment) {
        CommentInfrastructureEntity entity = jpaCommentRepository.findById(comment.getCommentId()).orElse(null);
        if (entity != null) {
            entity.setContent(comment.getContent());
            entity = jpaCommentRepository.save(entity);
        }
        return CommentMapper.toDomain(entity);


    }

    @Override
    public void deleteComment(UUID commentId, UUID userId) throws Exception {
        CommentInfrastructureEntity entity = jpaCommentRepository.findById(commentId).orElse(null);
        if (entity == null) {
            throw new Exception();
        } else if (!entity.getUserId().equals(userId)) {
            throw new Exception();
        } else jpaCommentRepository.softDelete(commentId);
    }

    @Override
    public CommentDomainEntity replyComment(CommentDomainEntity commentReply, UUID parentId) throws Exception {
        if (!jpaCommentRepository.existsById(parentId))
            throw new Exception();
        else return createComment(commentReply);
    }

    @Override
    public List<CommentDomainEntity> getByParentCommentId(UUID parentCommentId) throws Exception {
        if (!jpaCommentRepository.existsById(parentCommentId))
            throw new Exception();
        return jpaCommentRepository.findByParentCommentIdAndDeleteAtIsNotNull(parentCommentId).stream().map(CommentMapper::toDomain).toList();
    }

    @Override
    public List<CommentDomainEntity> getByPostId(UUID postId) throws Exception {
        if (!jpaPostRepository.existsById(postId))
            throw new Exception();
        return jpaCommentRepository.findByPostIdAndDeleteAtIsNotNull(postId).stream().map(CommentMapper::toDomain).toList();
    }
}
