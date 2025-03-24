package com.instagram.services.comment;

import com.instagram.model.entity.CommentDomainEntity;

import java.util.List;
import java.util.UUID;

public interface CommentDomainServices {
    CommentDomainEntity createComment(CommentDomainEntity comment);

    CommentDomainEntity updateComment(CommentDomainEntity comment);

    void deleteComment(UUID commentId, UUID userId);

    CommentDomainEntity replyComment(CommentDomainEntity commentReply, UUID parentId);

    List<CommentDomainEntity> getByParentCommentId(UUID parentCommentId);

    List<CommentDomainEntity> getByPostId(UUID postId);
}
