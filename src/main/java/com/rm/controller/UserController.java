package com.rm.controller;

import com.rm.entity.User;
import com.rm.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = {"http://localhost:4200/*"})
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

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
