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
public class UserInfrastructureEntity {  // entity để tương tác với csdl ( hạ tầng bên dưới )

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


    // sẽ gọi generateId() trước khi entity này được lưu vào csdl (chỉ áp dụng với entity mới)
    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
}
