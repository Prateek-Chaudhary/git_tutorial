package com.travelsystem.carrental.repositories;

import com.travelsystem.carrental.models.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailsRepository extends JpaRepository<CarDetails, String> {
}
