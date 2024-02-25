package com.travelsystem.hotelservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;
    private String hotelName;
    private String hotelType;
    private int totalRooms;
    private int availableRooms;
    private String location;
    private float rating;
}
