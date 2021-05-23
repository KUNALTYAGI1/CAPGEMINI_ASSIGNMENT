package com.ak.train.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ak.train.entity.Train;

@Repository
public interface TrainRepo  extends MongoRepository<Train,Long>{

	
	
	public List<Train>  findAllByName(String name);
	
	

	
}
