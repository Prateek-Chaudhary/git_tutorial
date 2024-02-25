package com.travelsystem.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class, args);
    }

    // These are the java based routing configurations.
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes()
                .route(p -> p.path("/customer/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("customerBreaker")
                                .setFallbackUri("forward:/fallback/customerMessage")))
                        .uri("lb://CUSTOMER-SERVICE"))
                .route(p -> p.path("/hotel/**")
                        .filters(f -> f.retry(retry -> retry.setRetries(3)
                                .setBackoff(Duration.ofMillis(100), Duration.ofMillis(500), 2, true)))
                        .uri("lb://HOTEL-SERVICE"))
                .route(p -> p.path("/carService/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("carServiceBreaker")
                                .setFallbackUri("forward:/fallback/carMessage")))
                        .uri("lb://CAR-RENTAL-SERVICE")).build();
    }
}
