package com.ak.service;

import java.util.List;

import com.ak.dto.TicketBookingRequest;
import com.ak.entity.Passenger;
import com.ak.entity.Ticket;

public interface TicketBookingService {

	
	
	
	public Ticket BookTicket(Ticket ticket,List<Passenger> passengers)throws Exception;
	
	
	
	
	public TicketBookingRequest getTicketByUserId(long userId)throws Exception;
	
	
	
	public TicketBookingRequest getTicketByTicketId(long ticketId)throws Exception;
	
	
	
	
	
	public boolean deleteTicket(long ticketId)throws Exception;
}
