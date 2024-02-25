package com.travelsystem.carrental.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDetails {

    @Id
    private String carNumber;
    private String carName;
    private String carType;
    private int seats;
    private String pricePerHour;
}