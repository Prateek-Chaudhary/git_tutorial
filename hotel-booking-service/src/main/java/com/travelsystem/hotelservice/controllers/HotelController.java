package com.travelsystem.hotelservice.controllers;

import com.travelsystem.hotelservice.dto.HotelDetailsDto;
import com.travelsystem.hotelservice.dto.ResponseDto;
import com.travelsystem.hotelservice.exceptions.ResourceNotFoundException;
import com.travelsystem.hotelservice.models.HotelDetails;
import com.travelsystem.hotelservice.services.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("hotel")
@Validated
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("createHotel")
    public ResponseEntity<ResponseDto> createHotelDetails(@Valid @RequestBody HotelDetailsDto hotelDetailsDto){
        hotelService.createHotelDetails(hotelDetailsDto);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.CREATED, "Hotel details are added successfully."), HttpStatus.CREATED);
    }

    @GetMapping("getHotelByHotelName")
    public ResponseEntity<HotelDetailsDto> getByHotelName(@RequestHeader String hotelName) {
        HotelDetailsDto hotelDetailsDto = hotelService.getByHotelName(hotelName);
        return new ResponseEntity<>(hotelDetailsDto, HttpStatus.OK);
    }

    @GetMapping("getHotelByHotelLocation")
    public ResponseEntity<HotelDetailsDto> getByHotelLocation(@RequestHeader String hotelLocation){
        HotelDetailsDto hotelDetailsDto = hotelService.getByHotelLocation(hotelLocation);
        return new ResponseEntity<>(hotelDetailsDto, HttpStatus.FOUND);
    }

    @GetMapping("getAllHotelsList")
    public ResponseEntity<List<HotelDetails>> getAllHotels(){
        List<HotelDetails> hotelDetailsList = hotelService.getAllHotels();
        if(hotelDetailsList.isEmpty()) throw new ResourceNotFoundException("Hotel list is empty");
        return new ResponseEntity<>(hotelDetailsList, HttpStatus.OK);
    }
}
