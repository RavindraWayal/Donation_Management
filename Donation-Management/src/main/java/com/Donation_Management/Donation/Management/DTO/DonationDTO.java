package com.Donation_Management.Donation.Management.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDTO {
    private  long id;
    private LocalDate date;
    private double amount;
    private String Label;
    private List<UserDTO> users;// here depending upon labels we can determine
    //// how many user give Donation to specific labels
}
