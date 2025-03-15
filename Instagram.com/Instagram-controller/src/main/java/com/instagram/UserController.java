package com.instagram;


import com.instagram.model.entity.UserDomainEntity;
import com.instagram.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/createUser")
    public UserDomainEntity createUser(@RequestBody UserDomainEntity user) {
        return userServices.createUser(user);
    }

}
