package com.Donation_Management.Donation.Management;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository<Donation> extends JpaRepository<Donation, Long> {
  List<Donation> findByLabel(String label);

}
