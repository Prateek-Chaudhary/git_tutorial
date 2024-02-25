package com.travelsystem.carrental.dto;

import com.travelsystem.carrental.models.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRentalDto {

    private long rentalId;
    private CarDetails carNumber;
    private HotelDetailsDto hotelDetails;
    private CustomerDetailsDto customerDetails;
}
