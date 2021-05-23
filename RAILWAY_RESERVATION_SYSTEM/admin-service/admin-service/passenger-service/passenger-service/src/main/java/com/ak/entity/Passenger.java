package com.ak.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="passenger")
public class Passenger {

	@Id
	private Long passengerId;
	private String name;
	private Date dob;
	
	private long allotedSeatId;
}
