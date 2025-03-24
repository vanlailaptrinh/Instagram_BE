package com.instagram.persistence.repository;

import com.instagram.persistence.model.entity.CommentInfrastructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface JpaCommentRepository extends JpaRepository<CommentInfrastructureEntity,UUID> {
    List<CommentInfrastructureEntity> findByPostIdAndDeleteAtIsNotNull(UUID postId);
    List<CommentInfrastructureEntity> findByParentCommentIdAndDeleteAtIsNotNull(UUID parentCommentId);
    @Modifying
    @Query("Update CommentInfrastructureEntity c set c.deleteAt = CURRENT_TIMESTAMP WHERE c.id = :commentId")
    void softDelete(@Param("commentId") UUID commentId);
}
