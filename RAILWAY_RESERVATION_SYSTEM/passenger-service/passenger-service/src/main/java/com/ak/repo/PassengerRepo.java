package com.ak.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ak.entity.Passenger;

@Repository
public interface PassengerRepo extends MongoRepository<Passenger,Long>{

}
