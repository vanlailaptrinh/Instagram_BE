package com.instagram.persistence.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "post")
public class PostInfrastructureEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID postId;

    @Column(nullable = false, columnDefinition = "varchar(255) comment 'caption'")
    private String caption;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column
    private Instant deletedAt;


    @Column(name = "userId", nullable = false)
    private UUID userId;  // Chỉ lưu ID, không ánh xạ entity đầy đủ


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private UserInfrastructureEntity user;

    @PrePersist
    public void generateId() {
        if (this.postId == null) {
            this.postId = UUID.randomUUID();
        }
    }
}
