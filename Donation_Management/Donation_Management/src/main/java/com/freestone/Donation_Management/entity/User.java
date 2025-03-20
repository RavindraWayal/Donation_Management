package com.freestone.Donation_Management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 255)
    @Column(nullable = false)
    private String password;

    @NotNull(message = "Role is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @NotBlank(message = "Contact is mandatory")
    @Size(min = 10, max = 10)
    @Column(nullable = false ,unique = true,length = 12)
    private String contact;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<Donation>donations;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> role.name().replace("Role_", "ROLE_"));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;  // Ensure Spring Security can access the password
    }
}
