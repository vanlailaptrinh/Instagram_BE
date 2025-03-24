package com.instagram.services.post.impl;

import com.instagram.model.entity.PostDomainEntity;
import com.instagram.repository.post.PostDomainRepository;
import com.instagram.services.post.PostDomainServices;
import com.instagram.services.post.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServicesImpl implements PostServices {
    @Autowired
    private PostDomainServices postDomainServices;
    @Override
    public boolean createPost(PostDomainEntity postDomainEntity) {
        return postDomainServices.createPost(postDomainEntity);
    }
}
