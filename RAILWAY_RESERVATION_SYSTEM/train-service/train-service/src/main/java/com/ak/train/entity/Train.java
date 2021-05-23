package com.ak.train.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="train")
public class Train {
	
	@Id
	private long trainId;
	private String name;
	private double farePerKm=5;
	private String startingTime;
	private String reachingTime;
	private List<Day> availableDays=new ArrayList<Day>();
	private  long totalSeats;
	private long availableSeats;
	private long seatBucketId;
	private long routeId;
	
	
	
	
	
	public enum Day{
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
	}

}
