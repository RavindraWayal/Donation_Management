package com.Donation_Management.Donation.Management.repository;

import com.Donation_Management.Donation.Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
public List<User> findByName(String name);
public List<User> findByEmail(String email);
public List<User> findByPassword(String password);
public List<User> findByRole(String role);

}
