package com.ak.dto;

import java.io.Serializable;
import java.util.List;

import com.ak.entity.Passenger;
import com.ak.entity.Ticket;

import lombok.Data;

@Data
public class TicketBookingRequest implements Serializable {

	
	private Ticket ticket;
	private List<Passenger> passengers;
	
}
