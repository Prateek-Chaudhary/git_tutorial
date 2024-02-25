package com.travelsystem.customermanagement.controllers;

import com.travelsystem.customermanagement.dto.CustomerDetailsDto;
import com.travelsystem.customermanagement.dto.ErrorResponseDto;
import com.travelsystem.customermanagement.dto.ResponseDto;
import com.travelsystem.customermanagement.exceptions.ResourceNotFoundException;
import com.travelsystem.customermanagement.models.CustomerDetails;
import com.travelsystem.customermanagement.services.CustomerDetailService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("customer")
@Tag(name = "Customer Details Controller", description = "It handles all apis related to customers")
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailService customerDetailService;

    @Operation(summary = "It create customer with details.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping("createCustomer")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerDetailsDto customerDetails){
        customerDetailService.createCustomer(customerDetails);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.CREATED, "Customer is created successfully"),
                HttpStatus.CREATED);
    }

    @Operation(summary = "It gives the list of all customers.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "301",
                    description = "Http status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("getAllCustomers")
    public ResponseEntity<List<CustomerDetails>> listAllCustomers(){
        List<CustomerDetails> customerDetailsList = customerDetailService.getAllCustomers();
        if (customerDetailsList.isEmpty()) throw new ResourceNotFoundException("Customer list is Empty.");
        return new ResponseEntity<>(customerDetailsList, HttpStatus.OK);
    }

    @Operation(summary = "It provide customer detail on the basis of email provided.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "301",
                    description = "Http status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("getCustomerByEmail")
//    @CircuitBreaker(name = "getCustomerCircuitBreaker", fallbackMethod = "byEmailCustomMessage")
    public ResponseEntity<CustomerDetailsDto> getCustomer(@RequestParam String email) {
        CustomerDetailsDto customerDetails = customerDetailService.getByEmail(email);
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> byEmailCustomMessage(String email, Exception ex){
        return new ResponseEntity<>(new ResponseDto(HttpStatus.EXPECTATION_FAILED, ex.getMessage()), HttpStatus.OK);
    }
}
