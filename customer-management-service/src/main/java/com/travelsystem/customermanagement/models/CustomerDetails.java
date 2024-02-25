package com.travelsystem.customermanagement.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {

    @Id
    private String customerId;
    private String customerName;
    private String country;
    private String state;
    private String city;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
}
