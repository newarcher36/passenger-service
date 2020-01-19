package com.miniproject.passengerservice.infrastructure.persistence.repository;

import com.miniproject.passengerservice.infrastructure.persistence.entity.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger,Long> {
}
