package com.rm.services;

import com.rm.dao.RoleRepository;
import com.rm.dao.UserRepository;
import com.rm.entity.Role;
import com.rm.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User registerNewUser(User user){
        return userRepository.save(user);
    }

    /*public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role2");
        roleRepository.save(adminRole);

        Role studentRole = new Role();
        studentRole.setRoleName("Student");
        studentRole.setRoleDescription("Student Role2");
        roleRepository.save(studentRole);

        User adminUser = new User();
        adminUser.setUserFirstName("Yassine");
        adminUser.setUserLastName("Yazz");
        adminUser.setUserName("yass@gmail.com");
        adminUser.setUserPassword("123");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userRepository.save(adminUser);

        User student = new User();
        student.setUserFirstName("YassineStudent");
        student.setUserLastName("Yazzdd");
        student.setUserName("yass@gmail.com");
        student.setUserPassword("123");
        Set<Role> studentRoles = new HashSet<>();
        studentRoles.add(studentRole);
        student.setRoles(studentRoles);
        userRepository.save(student);
    }*/
}
