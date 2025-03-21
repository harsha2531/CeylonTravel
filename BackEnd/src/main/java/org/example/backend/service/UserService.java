package org.example.backend.service;


import org.example.backend.dto.UserDTO;
import org.example.backend.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    ResponseEntity<String> saveUser(UserDTO userDTO);
    ResponseEntity<String> deleteUser(String email);
    UserDTO searchUser(String username);
    public ResponseEntity<String> updateUserProfile(String email, UserDTO userDTO);
    public ResponseEntity<String> updateUserPassword(String email, String oldPassword, String newPassword);
}