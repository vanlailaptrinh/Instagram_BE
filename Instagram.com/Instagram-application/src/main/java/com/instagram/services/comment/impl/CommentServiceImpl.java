package com.instagram.services.comment.impl;

import com.instagram.model.entity.CommentDomainEntity;
import com.instagram.services.comment.CommentDomainServices;
import com.instagram.services.comment.CommentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentServices {
    private final CommentDomainServices commentDomainServices;

    @Override
    public CommentDomainEntity createComment(CommentDomainEntity comment) {
        return commentDomainServices.createComment(comment);
    }

    @Override
    public CommentDomainEntity updateComment(CommentDomainEntity comment) {
        return commentDomainServices.updateComment(comment);
    }

    @Override
    public void deleteComment(UUID commentId,UUID userId) {
        commentDomainServices.deleteComment(commentId,userId);
    }

    @Override
    public CommentDomainEntity replyComment(CommentDomainEntity commentReply, UUID parentId) {
        return commentDomainServices.replyComment(commentReply, parentId);
    }

    @Override
    public List<CommentDomainEntity> getByParentCommentId(UUID parentCommentId) {
        return commentDomainServices.getByParentCommentId(parentCommentId);
    }

    @Override
    public List<CommentDomainEntity> getByPostId(UUID postId) {
        return commentDomainServices.getByPostId(postId);
    }
}
