
package com.ak.train.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="seat")
public class Seat {
	
	@Id
	private long seatId;
	
	private String seatType;
	private boolean available;
	private long occupiedByPassengerId;

}
