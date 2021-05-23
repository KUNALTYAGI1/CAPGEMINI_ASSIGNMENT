package com.ak.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ak.entity.Ticket;

@Repository
public interface TicketRepo extends MongoRepository<Ticket,Long>{
	
	
	
	
	public Ticket findByBookedByUserId(long bookedByUserId)throws Exception;

}
