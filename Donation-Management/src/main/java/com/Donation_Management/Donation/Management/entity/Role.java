package com.Donation_Management.Donation.Management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    List<User> users;
    int roleId;
    String roleName;
}