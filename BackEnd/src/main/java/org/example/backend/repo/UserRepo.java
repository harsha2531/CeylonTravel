package org.example.backend.repo;


import org.example.backend.entity.User;
import org.example.backend.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    //Optional<User> findByEmail(String email);
    List<User> findByRole(UserRole role);
    User findByEmail(String userName);

}
