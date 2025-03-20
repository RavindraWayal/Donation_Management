package com.freestone.Donation_Management.repository;

import com.freestone.Donation_Management.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import com.freestone.Donation_Management.repository.ReportRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    // Find reports by User ID
    List<Report> findByUserId(Long userId);

    // Find reports by Date
    List<Report> findByDateBetween(LocalDate startDate, LocalDate endDate);

    // Find report by Donation ID
    Report findByDonationId(Long donationId);

    // Delete report when expense is deleted
    void deleteByDonationId(Long expenseId);

}
