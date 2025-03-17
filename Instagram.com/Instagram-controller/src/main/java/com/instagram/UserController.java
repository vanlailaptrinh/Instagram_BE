package com.instagram;


import com.instagram.model.entity.UserDomainEntity;
import com.instagram.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PutMapping("/{userId}/update")
    public UserDomainEntity updateUser(@RequestBody UserDomainEntity user, @PathVariable UUID userId){
        return userServices.updateUser(user, userId);
    }

    @DeleteMapping("/{userId}/delete")
    public void deleteUser(@PathVariable UUID userId){
        return userServices.deleteUser(userId);
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
