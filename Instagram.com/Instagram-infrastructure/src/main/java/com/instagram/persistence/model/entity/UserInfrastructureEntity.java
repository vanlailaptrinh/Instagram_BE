package com.instagram.persistence.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Data
@Entity
@Getter
@Setter
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
