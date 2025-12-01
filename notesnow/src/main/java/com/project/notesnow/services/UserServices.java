package com.project.notesnow.services;

import com.project.notesnow.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    public UserDTO signUp(UserDTO userDTO);

    public UserDTO login(UserDTO userDTO);

}
