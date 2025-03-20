package com.freestone.Donation_Management.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PreAuthorize("hasAuthority('Role_ADMIN')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome to the Admin Dashboard";
    }
}