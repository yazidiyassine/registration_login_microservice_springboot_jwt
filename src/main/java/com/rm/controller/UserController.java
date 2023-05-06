package com.rm.controller;

import com.rm.entity.User;
import com.rm.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody  User user){
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "Cette URL n'est accessible qu'à l'administrateur";
    }

    @GetMapping({"/forStudent"})
    public String forStudent(){
        return "Cette URL n'est accessible qu'à l'étudiant";
    }
}
