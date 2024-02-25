package com.travelsystem.carrental.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsDto {

    private String customerName;
    private String country;
    private String state;
    private String city;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
}
