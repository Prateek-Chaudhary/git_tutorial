package com.travelsystem.carrental.controllers;

import com.travelsystem.carrental.dto.CarRentalDto;
import com.travelsystem.carrental.dto.ResponseDto;
import com.travelsystem.carrental.models.CarDetails;
import com.travelsystem.carrental.models.CarRental;
import com.travelsystem.carrental.services.CarService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carService")
@Validated
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("addCarDetails")
    public ResponseEntity<ResponseDto> addCarDetails(@Valid @RequestBody CarDetails carDetails){
        carService.addCarDetails(carDetails);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.CREATED, "Car details added successfully."), HttpStatus.CREATED);
    }

    @PostMapping("carRentalDetails")
    public ResponseEntity<ResponseDto> rentCarDetails(@RequestBody CarRental carRental){
        carService.carRentDetails(carRental);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Car rent details added."), HttpStatus.OK);
    }

    @GetMapping("getRentalInfo")
//    @CircuitBreaker(name = "rentalInfoBreaker", fallbackMethod = "rentalFallBack")
    public ResponseEntity<CarRentalDto> getRentalInfo(@RequestParam long rentalId){
        CarRentalDto carRentalDto = carService.getRentalInfo(rentalId);
        return new ResponseEntity<>(carRentalDto, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseDto> rentalFallBack(Exception exception){
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Fallback method is called"), HttpStatus.OK);
    }
}
