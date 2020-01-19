package com.miniproject.passengerservice.api;

import com.miniproject.passengerservice.infrastructure.client.BusClient;
import com.miniproject.passengerservice.infrastructure.persistence.entity.Passenger;
import com.miniproject.passengerservice.infrastructure.persistence.repository.PassengerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PassengerController {

    private final BusClient busClient;
    private final PassengerRepository passengerRepository;

    public PassengerController(BusClient busClient, PassengerRepository passengerRepository) {
        this.busClient = busClient;
        this.passengerRepository = passengerRepository;
    }

    @PostMapping(value = "/v1/passengers", consumes = APPLICATION_JSON_VALUE)
    public void createPassenger(@RequestBody Passenger passenger) {
        if (busClient.existsById(passenger.getBusId())) {
            passengerRepository.save(passenger);
        }
    }
}
