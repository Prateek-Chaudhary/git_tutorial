package com.travelsystem.carrental.services.feignClients;

import com.travelsystem.carrental.models.CustomerDetailsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerFallBack implements CustomerClient {
    @Override
    public ResponseEntity<CustomerDetailsDto> getCustomer(String email) {
        return null;
    }
}
