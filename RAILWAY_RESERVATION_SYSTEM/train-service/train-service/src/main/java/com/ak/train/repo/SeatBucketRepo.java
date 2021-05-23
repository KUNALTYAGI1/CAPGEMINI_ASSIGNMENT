package com.ak.train.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ak.train.entity.SeatBucket;

@Repository
public interface SeatBucketRepo extends MongoRepository<SeatBucket,Long> {
	
	
	
	
}
