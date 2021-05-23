
package com.ak.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

public class Seat implements Serializable{
	
	
	private long seatId;
	
	private String seatType;
	private boolean available;
	private long occupiedByPassengerId;

}
