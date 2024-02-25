package com.travelsystem.hotelservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDetailsDto {

    @NotEmpty(message = "Hotel name is required")
    private String hotelName;
    @NotEmpty(message = "Hotel type is required")
    private String hotelType;
    @NotNull(message = "Please provide total rooms in hotel")
    private int totalRooms;
    @NotNull(message = "Please give available rooms in hotel")
    private int availableRooms;
    @NotEmpty(message = "Provide location of the hotel")
    private String location;
    @NotNull(message = "Hotel rating is required")
    private float rating;
}
