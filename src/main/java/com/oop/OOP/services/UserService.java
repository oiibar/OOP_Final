package com.oop.OOP.services;

import com.oop.OOP.dto.UserDto;
import com.oop.OOP.entities.User;
import com.oop.OOP.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getEmail(), userDto.getName(), userDto.getEmail(), userDto.getRole());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public User updateUser(Long id, UserDto userDto) {
        User user = getUserById(id);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}



