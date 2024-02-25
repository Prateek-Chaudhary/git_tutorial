package com.travelsystem.carrental.services.feignClients;

import com.travelsystem.carrental.models.HotelDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "HOTEL-SERVICE", fallback = HotelFallBack.class)
public interface HotelClient {

    @GetMapping(value = "hotel/getHotelByHotelName")
    ResponseEntity<HotelDetailsDto> getByHotelName(@RequestHeader String hotelName);
}
