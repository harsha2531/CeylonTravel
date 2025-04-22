package org.example.backend.service.impl;

import org.example.backend.dto.UserDTO;
import org.example.backend.entity.User;
import org.example.backend.repo.UserRepo;
import org.example.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;


    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class));
    }

    public UserDTO saveUser(User user) {
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    public UserDTO updateUser(Long id, User user) {
        user.setId(id);
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted with id: " + id;
    }
}
