package com.instagram;

import com.instagram.model.entity.PostDomainEntity;
import com.instagram.services.post.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServices postServices;


    @PostMapping("/createPost")
    public boolean createPost(@RequestBody PostDomainEntity postDomainEntity) {
        System.out.println(postDomainEntity.getCreatedAt());
        return postServices.createPost(postDomainEntity);
    }
}
