package com.instagram.persistence.repository;

import com.instagram.persistence.model.entity.UserInfrastructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

//một interface trong Spring Boot sử dụng Spring Data JPA để thao tác với bảng
// UserInfrastructureEntity trong cơ sở dữ liệu
public interface JpaUserRepository extends JpaRepository<UserInfrastructureEntity, UUID> {
    List<UserInfrastructureEntity> findByUsernameContaining(String username);
}
