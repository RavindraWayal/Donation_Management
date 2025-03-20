package com.freestone.Donation_Management.service;



import com.freestone.Donation_Management.entity.Report;

import com.freestone.Donation_Management.repository.ReportRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ReportRepository reportRepository;


    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    // **1. User-wise Expense Summary Report**
    public Map<String, Double> getUserDonationSummary() {
        List<Report> reports = reportRepository.findAll();

        return reports.stream()
                .collect(Collectors.groupingBy(
                        Report::getUsername,
                        Collectors.summingDouble(Report::getAmount)
                ));
    }

    // **2. Date-wise Expense Report**
    public Map<LocalDate, List<Report>> getDonationByDate() {
        List<Report> reports = reportRepository.findAll();

        return reports.stream()
                .collect(Collectors.groupingBy(
                        report -> report.getDate().toLocalDate()
                ));
    }

    @Transactional // Ensures Hibernate fetches all data before session closes
    public List<Report> getAllReports() {
        List<Report> reports = reportRepository.findAll();

        // Force Hibernate to load lazy fields
        reports.forEach(report -> {
            report.getUser().getName();
            report.getUser().getUsername(); // Load user data
            report.getDonation().getLabel(); // Load expense data
        });

        return reports;
    }


}
