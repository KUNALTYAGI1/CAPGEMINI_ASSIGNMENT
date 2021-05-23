package com.ak.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="ticket")
public class Ticket {

	
	@Id
	private long ticketId;
	private long bookedByUserId;
	private String status="CNF";
	private Date bookingDate=new Date();	
	private List<Long> passengerIds;
	private long trainId;
	private String startingPoint;
	private String destinationPoint;
	private double totalFare;
	
}
