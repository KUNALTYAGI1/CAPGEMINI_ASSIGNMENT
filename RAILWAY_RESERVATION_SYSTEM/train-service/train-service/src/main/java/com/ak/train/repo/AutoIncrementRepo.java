package com.ak.train.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ak.train.entity.AutoIncrementDetails;

@Repository
public interface AutoIncrementRepo extends MongoRepository<AutoIncrementDetails,Long> {

}
