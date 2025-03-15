package com.instagram.persistence.repository;

import com.instagram.persistence.model.entity.UserInfrastructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserInfrastructureEntity, UUID> {
}
