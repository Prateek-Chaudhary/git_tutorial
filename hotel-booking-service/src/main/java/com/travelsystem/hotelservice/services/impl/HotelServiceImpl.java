package com.travelsystem.hotelservice.services.impl;

import com.travelsystem.hotelservice.dto.HotelDetailsDto;
import com.travelsystem.hotelservice.exceptions.ResourceNotFoundException;
import com.travelsystem.hotelservice.models.HotelDetails;
import com.travelsystem.hotelservice.repositories.HotelRepository;
import com.travelsystem.hotelservice.services.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createHotelDetails(HotelDetailsDto hotelDetailsDto) {
        HotelDetails hotelDetails = modelMapper.map(hotelDetailsDto, HotelDetails.class);
        hotelRepository.save(hotelDetails);
    }

    @Override
    public HotelDetailsDto getByHotelName(String hotelName) {
        HotelDetails hotelDetails = hotelRepository.findByHotelName(hotelName);
        if(hotelDetails == null) throw new ResourceNotFoundException("Hotel is not present with Hotel Name : "+hotelName);
        return modelMapper.map(hotelDetails, HotelDetailsDto.class);
    }

    @Override
    public HotelDetailsDto getByHotelLocation(String location) {
        HotelDetails hotelDetails = hotelRepository.findByLocation(location);
        return modelMapper.map(hotelDetails, HotelDetailsDto.class);
    }

    @Override
    public List<HotelDetails> getAllHotels() {
        return hotelRepository.findAll();
    }
}
