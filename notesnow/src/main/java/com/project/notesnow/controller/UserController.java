package com.project.notesnow.controller;


import com.project.notesnow.dto.UserDTO;
import com.project.notesnow.services.UserServices;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/signup")
    public UserDTO userSignup(@RequestBody UserDTO userDTO){
        return userServices.signUp(userDTO);
    }

    @PostMapping("/login")
    public UserDTO userLogin(@RequestBody UserDTO userDTO){
        return userServices.login(userDTO);
    }


}
