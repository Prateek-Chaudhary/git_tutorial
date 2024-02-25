package com.travelsystem.customermanagement.repositories;

import com.travelsystem.customermanagement.models.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, String> {
    CustomerDetails findByEmail(String email);
}
