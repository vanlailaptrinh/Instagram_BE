package com.instagram.services.comment.impl;

import com.instagram.model.entity.CommentDomainEntity;
import com.instagram.repository.comment.CommentDomainRepository;
import com.instagram.services.comment.CommentDomainServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentDomainServiceImpl implements CommentDomainServices {
    private final CommentDomainRepository commentDomainRepository;

    @Override
    public CommentDomainEntity createComment(CommentDomainEntity comment) {
        return commentDomainRepository.createComment(comment);
    }

    @Override
    public CommentDomainEntity updateComment(CommentDomainEntity comment) {
        return commentDomainRepository.updateComment(comment);
    }

    @Override
    public void deleteComment(UUID commentId, UUID userId) {
        try {
            commentDomainRepository.deleteComment(commentId,userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CommentDomainEntity replyComment(CommentDomainEntity commentReply, UUID parentId) {
        try {
            return commentDomainRepository.replyComment(commentReply, parentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CommentDomainEntity> getByParentCommentId(UUID parentCommentId) {
        try {
            return commentDomainRepository.getByParentCommentId(parentCommentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CommentDomainEntity> getByPostId(UUID postId) {
        try {
            return commentDomainRepository.getByPostId(postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
