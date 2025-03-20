package com.freestone.Donation_Management.service;

import com.freestone.Donation_Management.entity.Donation;
import com.freestone.Donation_Management.entity.Report;
import com.freestone.Donation_Management.repository.DonationRepository;
import com.freestone.Donation_Management.repository.ReportRepository;
import com.freestone.Donation_Management.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository, ReportRepository reportRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    public List<Donation> getUserDonations() {
        String username = getCurrentUsername();
        return donationRepository.findByUserId(userRepository.findByUsername(username).get().getId());
    }

    public Optional<Donation> getDonationById(Long id) {
        return donationRepository.findById(id);
    }

    @Transactional
    public Donation addDonation(Donation donation) {
        String username = getCurrentUsername();
        donation.setUser(userRepository.findByUsername(username).get());
        Donation savedDonation = donationRepository.save(donation);

        // Generate a report when a donation is added
        Report report = new Report();
        report.setName(donation.getUser().getName());
        report.setUsername(savedDonation.getUser().getUsername());
        report.setLabel(savedDonation.getLabel());
        report.setAmount(savedDonation.getAmount());
        report.setDate(savedDonation.getDate());
        report.setUser(savedDonation.getUser());
        report.setDonation(savedDonation);
        reportRepository.save(report);

        return savedDonation;
    }

    @Transactional
    public Donation updateDonation(Long id, Donation updatedDonation) {
        return donationRepository.findById(id).map(donation -> {
            donation.setLabel(updatedDonation.getLabel());
            donation.setAmount(updatedDonation.getAmount());
            donation.setDate(updatedDonation.getDate());

            Donation savedDonation = donationRepository.save(donation);

            // Update the existing report
            Report report = reportRepository.findByDonationId(savedDonation.getId());
            if (report == null) {
                report = new Report();
            }
            report.setName(donation.getUser().getName());
            report.setUsername(savedDonation.getUser().getUsername());
            report.setLabel(savedDonation.getLabel());
            report.setAmount(savedDonation.getAmount());
            report.setDate(savedDonation.getDate());
            report.setUser(savedDonation.getUser());
            report.setDonation(savedDonation);
            reportRepository.save(report);

            return savedDonation;
        }).orElseThrow(() -> new RuntimeException("Donation not found"));
    }

    @Transactional
    public void deleteDonation(Long id) {
        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        // Delete the corresponding report
        reportRepository.deleteByDonationId(donation.getId());

        donationRepository.delete(donation);
    }

    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName(); // Fetches logged-in user's username
    }
}
