package com.ak.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

public class SeatBucket implements Serializable{
	
	
	private long seatBucketId;
	
	private List<Long> seatIds;

}
