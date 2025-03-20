package com.freestone.Donation_Management.controller;

import com.freestone.Donation_Management.entity.Donation;
import com.freestone.Donation_Management.service.DonationService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donation")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PreAuthorize("hasAuthority('Role_USER')")
    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getUserDonations();
    }

    @PreAuthorize("hasAuthority('Role_USER')")
    @GetMapping("/{id}")
    public Optional<Donation> getDonationById(@Valid @PathVariable Long id) {
        return donationService.getDonationById(id);
    }

    @PreAuthorize("hasAuthority('Role_USER')")
    @PostMapping
    public Donation createDonation(@Valid @RequestBody Donation donation) {
        return donationService.addDonation(donation);
    }

    @PreAuthorize("hasAuthority('Role_USER')")
    @PutMapping("/{id}")
    public Donation updateDonation(@PathVariable Long id, @Valid @RequestBody Donation donation) {
        return donationService.updateDonation(id, donation);
    }

    @PreAuthorize("hasAuthority('Role_USER')")
    @DeleteMapping("/{id}")
    public void deleteDonation(@Valid @PathVariable Long id) {
        donationService.deleteDonation(id);
    }
}
