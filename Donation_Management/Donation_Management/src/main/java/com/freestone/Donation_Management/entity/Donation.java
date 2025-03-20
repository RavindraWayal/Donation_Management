package com.freestone.Donation_Management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please provide a description")
    @Size(min = 3, max = 50, message = "Description must be between 3 and 50 characters")
    @Column(nullable = false)
    private String label;


    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    @DecimalMax(value = "10000001", message = "Amount must be less or equal to 1 crore")
    @Column(nullable = false)
    private Double amount;


    @NotNull(message = "Please provide a date")
    @Column(nullable = false)
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
