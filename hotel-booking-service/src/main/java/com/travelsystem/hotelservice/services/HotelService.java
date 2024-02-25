package com.travelsystem.hotelservice.services;

import com.travelsystem.hotelservice.dto.HotelDetailsDto;
import com.travelsystem.hotelservice.models.HotelDetails;

import java.util.List;

public interface HotelService {
    void createHotelDetails(HotelDetailsDto hotelDetailsDto);

    HotelDetailsDto getByHotelName(String hotelName);

    HotelDetailsDto getByHotelLocation(String hotelLocation);

    List<HotelDetails> getAllHotels();
}
