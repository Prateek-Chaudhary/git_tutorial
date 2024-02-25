package com.travelsystem.customermanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Customer Details", description = "Contains all details of customer.")
public class CustomerDetailsDto {

    @NotEmpty(message = "Customer name can't be empty.")
    @Schema(description = "Customer Name", example = "Prateek Chaudhary")
    private String customerName;
    @NotEmpty(message = "Country is required.")
    @Schema(description = "Customer's Country", example = "India")
    private String country;
    @NotEmpty(message = "State is required.")
    @Schema(description = "Customer's State", example = "Uttar Pradesh")
    private String state;
    @NotEmpty(message = "City is required.")
    @Schema(description = "Customer's City", example = "Aligarh")
    private String city;
    @NotEmpty(message = "Email can't be empty.")
    @Email(message = "Please provide valid email address.")
    @Schema(description = "Customer email id", example = "prateek@gmail.com")
    private String email;
    @NotEmpty(message = "PhoneNumber is required.")
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$\n")
    @Schema(description = "Phone Number", example = "+919988998855")
    private String phoneNumber;
    @NotEmpty(message = "Gender is required.")
    @Schema(description = "Gender", example = "Male")
    private String gender;
    @NotNull(message = "Age is required.")
    @Schema(description = "Customer's Age", example = "21")
    private int age;
}
