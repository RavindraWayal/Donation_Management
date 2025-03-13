package com.Donation_Management.Donation.Management.controller;

import com.Donation_Management.Donation.Management.DTO.UserDTO;
import com.Donation_Management.Donation.Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
  private UserService userService;
//getUser
    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        // Implementation here
        return new ArrayList<>();
    }

    //CreateUser
    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        // Implementation here
        return new UserDTO();
    }

    //updateUser
    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        // Implementation here
        return new UserDTO();
    }

    //Get user by id
    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        // Implementation here
        return new UserDTO();
    }

    //get user by Name
    @GetMapping("/users/name/{name}")
    public UserDTO getUserByName(@PathVariable String name) {
        // Implementation here
        return new UserDTO();
    }
}
