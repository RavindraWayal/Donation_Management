package com.Donation_Management.Donation.Management.repository;

import com.Donation_Management.Donation.Management.entity.DonationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationDetailsRepository extends JpaRepository<DonationDetails,Integer> {

}
