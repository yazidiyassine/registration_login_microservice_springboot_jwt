package com.rm.repository;

import com.rm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User readByUserName(String email);

    @Query("SELECT u FROM User u JOIN u.role r WHERE r.roleName != 'ADMIN'")
    List<User> findAllUsersExcludingAdmin();

}
