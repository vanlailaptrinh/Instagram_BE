package com.instagram.model.entity;


import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class PostDomainEntity {
    private UUID postId;
    private String caption;
    private Instant createdAt;
    private Instant deleted_at;
    private UUID userId;

    public PostDomainEntity() {
        this.createdAt = Instant.now();
    }

    public UUID getPostId() {
        return postId;
    }

    public String getCaption() {
        return caption;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getDeleted_at() {
        return deleted_at;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setDeleted_at(Instant deleted_at) {
        this.deleted_at = deleted_at;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
