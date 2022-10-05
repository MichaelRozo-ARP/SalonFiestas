package com.SalonFiestas.Partyroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.SalonFiestas.Partyroom.entities"})
@SpringBootApplication
public class Partyroom {

    public static void main(String[] args) {
        SpringApplication.run(Partyroom.class, args);
    }

}
