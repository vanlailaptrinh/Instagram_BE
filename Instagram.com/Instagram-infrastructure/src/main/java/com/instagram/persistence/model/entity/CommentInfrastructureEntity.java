package com.instagram.persistence.model.entity;

import com.instagram.persistence.util.IdGenerator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
public class CommentInfrastructureEntity {
    @Id
    private UUID commentId;
    @Column(nullable = false, updatable = false)
    private UUID postId;
    @Column(nullable = false, updatable = false)
    private UUID userId;
    @Column
    private String content;
    @Column
    private UUID parentCommentId;
    @Column(nullable = false, updatable = false)
    private Instant createAt;
    @Column
    private Instant deleteAt;

    //relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private UserInfrastructureEntity user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "postId", referencedColumnName = "postId", insertable = false, updatable = false)
//    private PostInfrastructureEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentCommentId", referencedColumnName = "commentId", insertable = false, updatable = false)
    private CommentInfrastructureEntity parentComment;

    public CommentInfrastructureEntity(UUID commentId, UUID postId, UUID userId, String content, UUID parentCommentId, Instant createAt, Instant deleteAt) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.parentCommentId = parentCommentId;
        this.createAt = createAt;
        this.deleteAt = deleteAt;
    }

    @PrePersist
    private void genIdAndDate(){
        if (this.commentId == null) {
            this.commentId = IdGenerator.generateUUID();
        }
        if (this.createAt == null) {
            this.createAt = Instant.now();
        }
    }
}
