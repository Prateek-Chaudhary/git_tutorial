package com.travelsystem.carrental.services.feignClients;

import com.travelsystem.carrental.models.CustomerDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CUSTOMER-SERVICE", fallback = CustomerFallBack.class)
public interface CustomerClient {

    @GetMapping(value = "customer/getCustomerByEmail")
    ResponseEntity<CustomerDetailsDto> getCustomer(@RequestParam String email);
}