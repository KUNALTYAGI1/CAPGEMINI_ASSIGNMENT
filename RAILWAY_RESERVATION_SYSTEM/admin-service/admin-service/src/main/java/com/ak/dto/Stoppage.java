package com.ak.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

public class Stoppage {

	
	
	private long stoppageId;
	private int duration;//in minutes
	private String stationName;
	private int position;
	private double nextStoppageDistance; //in KM
	
}
