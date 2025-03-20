package com.instagram.persistence.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "role")
public class RoleInfrastructureEntity {
    @Id
    @GeneratedValue
    private UUID roleId;

    @Column(columnDefinition = "varchar(25) comment 'role name'", nullable = false, unique = true)
    private String roleName;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<UserInfrastructureEntity> users = new HashSet<>();

    public RoleInfrastructureEntity(String roleName) {
        this.roleName = roleName;
    }
}
