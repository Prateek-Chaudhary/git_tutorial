package com.travelsystem.carrental.services.impl;

import com.travelsystem.carrental.dto.CarRentalDto;
import com.travelsystem.carrental.models.CarDetails;
import com.travelsystem.carrental.models.CarRental;
import com.travelsystem.carrental.models.CustomerDetailsDto;
import com.travelsystem.carrental.models.HotelDetailsDto;
import com.travelsystem.carrental.repositories.CarDetailsRepository;
import com.travelsystem.carrental.repositories.CarRentalRepository;
import com.travelsystem.carrental.services.CarService;
import com.travelsystem.carrental.services.feignClients.CustomerClient;
import com.travelsystem.carrental.services.feignClients.HotelClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDetailsRepository carDetailsRepository;
    @Autowired
    private CarRentalRepository carRentalRepository;
    @Autowired
    @Qualifier("com.travelsystem.carrental.services.feignClients.HotelClient")
    private HotelClient hotelClient;
    @Autowired
    @Qualifier("com.travelsystem.carrental.services.feignClients.CustomerClient")
    private CustomerClient customerClient;

    @Override
    public void addCarDetails(CarDetails carDetails) {
        carDetailsRepository.save(carDetails);
    }

    @Override
    public void carRentDetails(CarRental carRental) {
        carRentalRepository.save(carRental);
    }

    @Override
    public CarRentalDto getRentalInfo(long rentalId) {
        CarRental carRental = carRentalRepository.findByRentalId(rentalId);
        ResponseEntity<HotelDetailsDto> hdd = hotelClient.getByHotelName(carRental.getHotelName());
        ResponseEntity<CustomerDetailsDto> cdd = customerClient.getCustomer(carRental.getCustomerEmail());
        HotelDetailsDto hotelDetailsDto = hdd == null ? null : hdd.getBody();
        CustomerDetailsDto customerDetailsDto = cdd == null ? null : cdd.getBody();
        CarRentalDto carRentalDto = new CarRentalDto();
        carRentalDto.setCarNumber(carRental.getCarNumber());
        carRentalDto.setRentalId(carRental.getRentalId());
        if(customerDetailsDto != null) carRentalDto.setCustomerDetails(customerDetailsDto);
        if(hotelDetailsDto != null) carRentalDto.setHotelDetails(hotelDetailsDto);
        return carRentalDto;
    }
}
