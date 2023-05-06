package com.rm.services;

import com.rm.repository.RoleRepository;
import com.rm.repository.UserRepository;
import com.rm.entity.Role;
import com.rm.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(User user){

        Role role = roleRepository.findById("Student").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userRepository.save(user);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

    public List<User> getUsers(){
        return userRepository.findAllUsersExcludingAdmin();
    }

   public void deleteUser(int id){
        userRepository.deleteById(id);
   }

   public User updateUser(User user){
       Optional<User> optionalUser = userRepository.findById(user.getApogee());
       User existingUser = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

       existingUser.setUserName(user.getUserName());
       existingUser.setUserFirstName(user.getUserFirstName());
       existingUser.setUserPassword(user.getUserPassword());

       return userRepository.save(existingUser);
   }
}
