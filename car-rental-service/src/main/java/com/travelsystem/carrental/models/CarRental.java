package com.travelsystem.carrental.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rentalId;
    @OneToOne
    private CarDetails carNumber;
    private String customerEmail;
    private String hotelName;
}
