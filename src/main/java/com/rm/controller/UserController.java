package com.rm.controller;

import com.rm.entity.User;
import com.rm.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*@PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }*/

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody  User user){
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forStudent"})
    public String forStudent(){
        return "This URL is only accessible to the student";
    }
}
