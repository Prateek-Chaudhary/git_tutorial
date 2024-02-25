package com.travelsystem.hotelservice.repositories;

import com.travelsystem.hotelservice.models.HotelDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelDetails, Long> {
    HotelDetails findByHotelName(String hotelName);

    HotelDetails findByLocation(String location);
}
