package com.instagram;


import com.instagram.model.entity.UserDomainEntity;
import com.instagram.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //rcm dùng Constructor Injection (giống C#)
    @Autowired
    private UserServices userServices;

    @PostMapping("/createUser")
    public UserDomainEntity createUser(@RequestBody UserDomainEntity user) {
        return userServices.createUser(user);
    }

    @GetMapping("/get-by-user-name")
    public List<UserDomainEntity> findUsersByUsername(@RequestParam String username) {
        return userServices.findUsersByUsername(username);
    }

    @GetMapping("/get-all")
    public List<UserDomainEntity> getAllUsers() {
        return userServices.getAllUsers();
    }
}
