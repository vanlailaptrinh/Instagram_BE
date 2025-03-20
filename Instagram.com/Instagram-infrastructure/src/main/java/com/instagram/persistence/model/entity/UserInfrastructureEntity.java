package com.instagram.persistence.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.*;

@Data
@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "user")
public class UserInfrastructureEntity {  // entity để tương tác với csdl ( hạ tầng bên dưới )

    @Id
    @GeneratedValue
    private UUID userId;

    @Column(columnDefinition = "varchar(50) comment 'user name'", nullable = false)
    private String username;

    @Column(columnDefinition = "varchar(25) comment 'password'",nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(50) comment 'email'", nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostInfrastructureEntity> postList ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    )
    private Set<RoleInfrastructureEntity> roles = new HashSet<>();

    // sẽ gọi generateId() trước khi entity này được lưu vào csdl (chỉ áp dụng với entity mới)
    @PrePersist
    public void generateId() {
        if (this.userId == null) {
            this.userId = UUID.randomUUID();
        }
    }

    public UserInfrastructureEntity(UUID userId) {
        this.userId = userId;
    }

    public UserInfrastructureEntity() {
    }
}

