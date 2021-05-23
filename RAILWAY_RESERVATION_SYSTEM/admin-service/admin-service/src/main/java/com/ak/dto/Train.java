package com.ak.dto;

import java.util.List;

import lombok.Data;

@Data

public class Train {
	
	
	private long trainId;
	private String name;
	private double farePerKm;
	private String startingTime;
	private String reachingTime;
	private List<Day> availableDays;
	private  long totalSeats;
	private long availableSeats;
	private long seatBucketId;
	private long routeId;
	
	
	
	
	
	public enum Day{
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
	}

}
