package com.Donation_Management.Donation.Management.controller;

import com.Donation_Management.Donation.Management.DTO.UserDTO;
import com.Donation_Management.Donation.Management.entity.User;
import com.Donation_Management.Donation.Management.repository.UserRepository;
import com.Donation_Management.Donation.Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    @GetMapping("/get/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }
    @GetMapping("/findByName/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }
}