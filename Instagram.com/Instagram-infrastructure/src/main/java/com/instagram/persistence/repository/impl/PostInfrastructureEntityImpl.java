package com.instagram.persistence.repository.impl;

import com.instagram.model.entity.PostDomainEntity;
import com.instagram.persistence.mapper.PostMapper;
import com.instagram.persistence.model.entity.PostInfrastructureEntity;
import com.instagram.persistence.repository.JpaPostRepository;
import com.instagram.repository.post.PostDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostInfrastructureEntityImpl implements PostDomainRepository {

    @Autowired
    private JpaPostRepository jpaPostRepository;

    @Override
    public boolean createPost(PostDomainEntity postDomainEntity) {
        try {
            jpaPostRepository.save(PostMapper.toEntity(postDomainEntity));
            return true;
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu bài viết: " + e.getMessage());
            return false;
        }
    }

}
