package org.example.backend.service;

import org.example.backend.dto.UserDTO;
import org.example.backend.entity.User;
import org.example.backend.enums.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface UserService {
    public List<UserDTO> getAllUsers();

    public Optional<UserDTO> getUserById(Long id);

    public UserDTO saveUser(User user);

    public UserDTO updateUser(Long id, User user);

    public String deleteUser(Long id);

}
