package com.travelsystem.carrental.services.feignClients;

import com.travelsystem.carrental.models.HotelDetailsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelFallBack implements HotelClient {
    @Override
    public ResponseEntity<HotelDetailsDto> getByHotelName(String hotelName) {
        return null;
    }
}
