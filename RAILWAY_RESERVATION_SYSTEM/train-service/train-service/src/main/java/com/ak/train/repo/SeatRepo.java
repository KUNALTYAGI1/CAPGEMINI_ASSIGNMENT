package com.ak.train.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ak.train.entity.Seat;

@Repository
public interface SeatRepo extends MongoRepository<Seat, Long>{

}
