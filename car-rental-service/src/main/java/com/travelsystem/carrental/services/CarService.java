package com.travelsystem.carrental.services;

import com.travelsystem.carrental.dto.CarRentalDto;
import com.travelsystem.carrental.models.CarDetails;
import com.travelsystem.carrental.models.CarRental;

public interface CarService {
    void addCarDetails(CarDetails carDetails);

    void carRentDetails(CarRental carRental);

    CarRentalDto getRentalInfo(long rentalId);
}
