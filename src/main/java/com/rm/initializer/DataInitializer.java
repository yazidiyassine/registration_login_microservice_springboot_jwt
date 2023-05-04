package com.rm.initializer;

import com.rm.repository.RoleRepository;
import com.rm.repository.UserRepository;
import com.rm.entity.Role;
import com.rm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository rolesRepository;

    private final UserRepository userRepository;

    private final Environment env;

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public DataInitializer(UserRepository userRepository, RoleRepository rolesRepository, Environment env, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.env = env;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = rolesRepository.getByRoleName("ADMIN");

        User adminUser = userRepository.readByUserName(env.getProperty("admin.userName"));
        if (adminRole == null && adminUser == null){
            adminRole = new Role();
            adminRole.setRoleName("ADMIN");
            adminRole.setRoleDescription("Admin Role");
            adminUser = new User();
            adminUser.setUserFirstName(env.getProperty("admin.userFirstName"));
            adminUser.setUserLastName(env.getProperty("admin.userLastName"));
            adminUser.setUserName(env.getProperty("admin.userName"));
            adminUser.setUserPassword(passwordEncoder.encode(env.getProperty("admin.userPassword")));
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            adminUser.setRole(adminRoles);
            userRepository.save(adminUser);
            rolesRepository.save(adminRole);
        }
        Role studentRole = rolesRepository.getByRoleName("STUDENT");
        if (studentRole == null){
            studentRole = new Role();
            studentRole.setRoleName("STUDENT");
            studentRole.setRoleDescription("Student Role");
            rolesRepository.save(studentRole);
        }
    }
}
