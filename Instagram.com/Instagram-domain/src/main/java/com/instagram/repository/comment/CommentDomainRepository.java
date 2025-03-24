package com.instagram.repository.comment;

import com.instagram.model.entity.CommentDomainEntity;

import java.util.List;
import java.util.UUID;

public interface CommentDomainRepository {

    CommentDomainEntity createComment(CommentDomainEntity comment);

    CommentDomainEntity updateComment(CommentDomainEntity comment);

    void deleteComment(UUID commentId, UUID userId) throws Exception;

    CommentDomainEntity replyComment(CommentDomainEntity commentReply, UUID parentId) throws Exception;

    List<CommentDomainEntity> getByParentCommentId(UUID parentCommentId) throws Exception;

    List<CommentDomainEntity> getByPostId(UUID postId) throws Exception;


}
