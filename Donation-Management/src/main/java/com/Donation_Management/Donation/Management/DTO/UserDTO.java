package com.Donation_Management.Donation.Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
     private Integer userId;
     private String userName;
     private String email;
     private String password;
}
