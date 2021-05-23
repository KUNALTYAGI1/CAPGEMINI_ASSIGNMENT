package com.ak.train.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="stoppage")
public class Stoppage {

	@Id
	private long stoppageId;
	private int duration;//in minutes
	private String stationName;
	private int position;
	private double nextStoppageDistance=10; //in KM  //this is default distance for next station
	
}
