package com.travelsystem.apigateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fallback")
public class FallbackController {

    @GetMapping("customerMessage")
    public ResponseEntity<String> getCustomerMessage(){
        return new ResponseEntity<>("This is a customer fallback method.", HttpStatus.OK);
    }

    @GetMapping("carMessage")
    public ResponseEntity<String> getCarMessage(){
        return new ResponseEntity<>("This is a car fallback method.", HttpStatus.OK);
    }
}
