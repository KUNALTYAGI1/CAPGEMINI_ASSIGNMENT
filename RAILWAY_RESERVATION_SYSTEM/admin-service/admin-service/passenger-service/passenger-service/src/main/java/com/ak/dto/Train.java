package com.ak.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

public class Train {
	
	
	private long trainId;
	private String name;
	private double farePerKm=5;
	private String startingTime;
	private String reachingTime;
	private List<Day> availableDays;
	private  long totalSeats;
	private long availableSeats;
	private long seatBucketId;
	private long routeId;
	
	private double totalPrice;
	
	
	
	public enum Day{
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
	}

}
