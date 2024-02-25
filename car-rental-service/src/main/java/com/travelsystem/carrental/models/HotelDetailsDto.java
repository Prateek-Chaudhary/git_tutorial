package com.travelsystem.carrental.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDetailsDto {

    private String hotelName;
    private String hotelType;
    private int totalRooms;
    private int availableRooms;
    private String location;
    private float rating;
}
