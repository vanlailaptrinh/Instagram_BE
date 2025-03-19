package com.instagram.repository.post;

import com.instagram.model.entity.PostDomainEntity;

public interface PostDomainRepository {
    public boolean createPost(PostDomainEntity postDomainEntity);
}
