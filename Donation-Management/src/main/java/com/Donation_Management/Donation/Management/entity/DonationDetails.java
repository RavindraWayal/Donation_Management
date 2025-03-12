package com.Donation_Management.Donation.Management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class DonationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reportId;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "userId")
    User admin;

    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime generatedOn;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal totalAmount;

    @Column(nullable = false)
    int donationCount;
    @ManyToOne
    @JoinColumn(name = "userId" ,nullable=false)
    private User user;
}

