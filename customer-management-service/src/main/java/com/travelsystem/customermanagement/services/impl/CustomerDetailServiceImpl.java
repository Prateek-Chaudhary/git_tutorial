package com.travelsystem.customermanagement.services.impl;

import com.travelsystem.customermanagement.dto.CustomerDetailsDto;
import com.travelsystem.customermanagement.exceptions.ResourceNotFoundException;
import com.travelsystem.customermanagement.models.CustomerDetails;
import com.travelsystem.customermanagement.repositories.CustomerDetailsRepository;
import com.travelsystem.customermanagement.services.CustomerDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomerDetailServiceImpl implements CustomerDetailService {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createCustomer(CustomerDetailsDto customerDetails) {
        CustomerDetails customerDetail = modelMapper.map(customerDetails, CustomerDetails.class);
        UUID customerId = UUID.randomUUID();
        customerDetail.setCustomerId(String.valueOf(customerId));
        customerDetailsRepository.save(customerDetail);
    }

    @Override
    public List<CustomerDetails> getAllCustomers() {
        return customerDetailsRepository.findAll();
    }

    @Override
    public CustomerDetailsDto getByEmail(String email) {
        CustomerDetails customerDetails = customerDetailsRepository.findByEmail(email);
        if(customerDetails == null) throw new ResourceNotFoundException("Customer not available with Email :"+email);
        return modelMapper.map(customerDetails, CustomerDetailsDto.class);
    }
}
