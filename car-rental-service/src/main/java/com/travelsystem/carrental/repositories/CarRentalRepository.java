package com.travelsystem.carrental.repositories;

import com.travelsystem.carrental.models.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
    CarRental findByRentalId(long rentalId);
}
