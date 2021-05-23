package com.ak.train.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ak.train.entity.Stoppage;

@Repository
public interface StoppageRepo  extends MongoRepository<Stoppage,Long>{
	
	
	@Query("{$max:'stoppageId'}")
	public int findMaximumIndex();

}
