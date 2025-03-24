package com.instagram.model.entity;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class CommentDomainEntity {
    private UUID commentId;
    private UUID postId;
    private UUID userId;
    private String content;
    private UUID parentCommentId;
    private Instant createAt;
    private Instant deleteAt;

    /**
     * Constructor chuyển dữ liệu
     * @param commentId
     * @param postId
     * @param userId
     * @param content
     * @param parentCommentId
     * @param createAt
     */
    public CommentDomainEntity(UUID commentId, UUID postId, UUID userId, String content, UUID parentCommentId, Instant createAt) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.parentCommentId = parentCommentId;
        this.createAt = createAt;
    }

    /**
     * Constructor tạo comment reply comment khác
     *
     * @param parentCommentId id comment reply
     * @param content         nội dung text
     * @param userId          id người dùng
     * @param postId          id bài viết
     * @param createAt        thời gian tạo comment
     */
    public CommentDomainEntity(UUID postId, UUID userId, String content, UUID parentCommentId, Instant createAt) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.parentCommentId = parentCommentId;
        this.createAt = createAt;
    }

    /**
     * Constructor tạo comment cho bài viết
     *
     * @param content  nội dung text
     * @param userId   id người dùng
     * @param postId   id bài viết
     * @param createAt thời gian tạo comment
     */
    public CommentDomainEntity(UUID postId, UUID userId, String content, Instant createAt) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.createAt = createAt;
    }
}
