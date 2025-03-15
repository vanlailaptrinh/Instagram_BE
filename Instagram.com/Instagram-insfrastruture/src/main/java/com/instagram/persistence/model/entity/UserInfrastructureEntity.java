package com.instagram.persistence.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@DynamicUpdate
@DynamicInsert
public class UserInfrastructureEntity {

    @Id
    private UUID id;

    @Column(columnDefinition = "varchar(50) comment 'user name'", nullable = false)
    private String username;

    @Column(columnDefinition = "varchar(25) comment 'password'",nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(50) comment 'email'", nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean active;

    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
}
