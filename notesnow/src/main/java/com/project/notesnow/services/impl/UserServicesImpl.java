package com.project.notesnow.services.impl;

import com.project.notesnow.dto.UserDTO;
import com.project.notesnow.entity.User;
import com.project.notesnow.repository.UserRepository;
import com.project.notesnow.services.UserServices;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServicesImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO signUp(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User savedUser =  userRepository.save(user);
        return new UserDTO(savedUser.getUserName(), null, savedUser.getEmail());
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        User user = userRepository.findByUserName(userDTO.getUserName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return new UserDTO( user.getUserName(), null, user.getEmail());
    }
}
