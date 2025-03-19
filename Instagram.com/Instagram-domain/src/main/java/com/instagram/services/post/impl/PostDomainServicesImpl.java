package com.instagram.services.post.impl;

import com.instagram.model.entity.PostDomainEntity;
import com.instagram.repository.post.PostDomainRepository;
import com.instagram.services.post.PostDomainServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDomainServicesImpl implements PostDomainServices {

    @Autowired
    private PostDomainRepository postDomainRepository;
    @Override
    public boolean createPost(PostDomainEntity postDomainEntity) {
        return postDomainRepository.createPost(postDomainEntity);
    }
}
