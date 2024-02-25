package com.travelsystem.customermanagement.services;

import com.travelsystem.customermanagement.dto.CustomerDetailsDto;
import com.travelsystem.customermanagement.models.CustomerDetails;

import java.util.List;

public interface CustomerDetailService {
    void createCustomer(CustomerDetailsDto customerDetails);

    List<CustomerDetails> getAllCustomers();

    CustomerDetailsDto getByEmail(String email);
}
