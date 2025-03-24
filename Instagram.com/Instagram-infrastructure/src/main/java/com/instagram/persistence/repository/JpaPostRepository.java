package com.instagram.persistence.repository;

import com.instagram.persistence.model.entity.PostInfrastructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaPostRepository extends JpaRepository<PostInfrastructureEntity, UUID> {
}
